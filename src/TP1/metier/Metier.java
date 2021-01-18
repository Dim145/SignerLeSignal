package TP1.metier;

import TP1.Controlleur;
import TP1.TypeSignal;

/**
 * The type Metier.
 */
public class Metier
{
    /**
     * Utilisation de ces valeurs pour savoir quels partie d'un panel est a colorier.
     * ces valeurs spÃ©cifique pour pouvoir les additionner de faÃ§on simple
     * (seulement 2 cotÃ©s max a colorier par panel/cases.
     * donc 10 + 5  = 15
     * 10 + 20 = 30
     * 20 + 5  = 25
     * ect...
     * c'est toujours reconnaisable.
     */
    public static final int VAL_HAUT   = 5;
    /**
     * The constant VAL_DROITE.
     */
    public static final int VAL_DROITE = 10;
    /**
     * The constant VAL_BAS.
     */
    public static final int VAL_BAS    = 20;
    /**
     * The constant VAL_GAUCHE.
     */
    public static final int VAL_GAUCHE = 40;

    private final Controlleur ctrl;
    private TypeSignal typeCourant;

    /**
     * Instantiates a new Metier.
     *
     * @param controlleur the controlleur
     */
    public Metier(Controlleur controlleur)
	{
        this.ctrl = controlleur;

        this.typeCourant = TypeSignal.NRZ;
    }

    /**
     * Change type.
     *
     * @param type the type
     */
    public void changeType( TypeSignal type )
    {
        if( type == null ) return;

        this.typeCourant = type;
    }

    /**
     * Creer tableaux.
     *
     * @param bits the bits
     */
    public void creerTableaux( String bits )
    {
        if( bits == null ) return;

        new Thread(() ->
        {
            int[] tabDessin = new int[bits.length()*2];

            for (int cpt = 0; cpt < bits.length(); cpt++ )
            {
                char current = bits.charAt(cpt);
                char suivant = cpt < bits.length()-1 ? bits.charAt(cpt+1) : '2';

                switch (Metier.this.typeCourant)
                {
                    case NRZ ->
                    {
                        tabDessin[cpt*2] = tabDessin[cpt*2+1] = current == '0' ? VAL_BAS : VAL_HAUT;

                        if( suivant != '2' && suivant != current )
                            tabDessin[cpt*2+1] += VAL_DROITE;
                    }

                    case MANCHESTER ->
                    {
                        tabDessin[cpt*2  ] = (current == '1' ? VAL_HAUT : VAL_BAS) + VAL_DROITE;
                        tabDessin[cpt*2+1] = current == '1' ? VAL_BAS  : VAL_HAUT;

                        if ( suivant != '2' && suivant == current )
                            tabDessin[cpt*2+1] += VAL_DROITE;

                    }

                    case MANCHESTER_DIFF ->
                    {
                        if( cpt == 0 )
                        {
                            tabDessin[0] = (current == '0' ? VAL_HAUT : VAL_BAS) + VAL_DROITE;
                            tabDessin[1] =  current == '0' ? VAL_BAS  : VAL_HAUT;
                        }
                        else
                        {
                            boolean isBas = tabDessin[(cpt - 1) * 2 + 1] == VAL_BAS || tabDessin[(cpt - 1) * 2 + 1] == VAL_BAS + VAL_DROITE;
                            if ( current == '0' )
                            {
                                tabDessin[cpt*2  ] = tabDessin[(cpt-1)*2  ];
                                tabDessin[cpt*2+1] = isBas ? VAL_BAS : VAL_HAUT;
                            }
                            else
                            {
                                tabDessin[cpt*2  ] = (tabDessin[(cpt-1)*2] == (VAL_BAS + VAL_DROITE) ? VAL_HAUT : VAL_BAS) + VAL_DROITE;
                                tabDessin[cpt*2+1] = isBas ? VAL_HAUT : VAL_BAS;
                            }
                        }

                        if (suivant == '0')
                            tabDessin[cpt*2+1] += VAL_DROITE;
                    }

                    case MILLER ->
                    {
                        if( cpt == 0 )
                        {
                            tabDessin[0] = (current == '1' ? VAL_BAS + VAL_DROITE : VAL_BAS);
                            tabDessin[1] = current == '1' ? VAL_HAUT  : VAL_BAS;
                        }
                        else
                        {
                            if( current == '1' )
                            {
                                tabDessin[cpt*2  ] = tabDessin[(cpt-1)*2+1] + VAL_DROITE;
                                tabDessin[cpt*2+1] = tabDessin[(cpt-1)*2+1] == VAL_BAS ? VAL_HAUT : VAL_BAS;
                            }
                            else
                            {
                                tabDessin[cpt*2  ] = bits.charAt(cpt-1) == '0' ? (tabDessin[(cpt-1)*2] == VAL_BAS ? VAL_HAUT : VAL_BAS) : tabDessin[(cpt-1)*2+1];
                                tabDessin[cpt*2+1] = tabDessin[cpt*2];
                            }
                        }

                        if ( current == '0' && suivant == current )
                            tabDessin[cpt*2+1] += VAL_DROITE;
                    }
                }
            }

            //for (int i : tabDessin) System.out.print(i + " | ");

            this.ctrl.update(tabDessin);

        }).start();
	}
}
