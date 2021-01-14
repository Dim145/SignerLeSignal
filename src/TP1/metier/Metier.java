package TP1.metier;

import TP1.Controlleur;
import TP1.TypeSignal;

public class Metier
{
    /**
     * Utilisation de ces valeurs pour savoir quels partie d'un panel est a colorier.
     * ces valeurs spécifique pour pouvoir les additionner de façon simple
     * (seulement 2 cotés max a colorier par panel/cases.
     * donc 10 + 5  = 15
     *      10 + 20 = 30
     *      20 + 5  = 25
     *      ect...
 *      c'est toujours reconnaisable.
     */
    public static final int VAL_HAUT   = 5;
    public static final int VAL_DROITE = 10;
    public static final int VAL_BAS    = 20;
    public static final int VAL_GAUCHE = 40;

    private Controlleur ctrl;
    private TypeSignal typeCourant;

	public Metier(Controlleur controlleur)
	{
        this.ctrl = controlleur;

        this.typeCourant = TypeSignal.NRZ;
    }

    public void changeType( TypeSignal type )
    {
        if( type == null ) return;

        this.typeCourant = type;
    }

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
                            if ( current == '0' )
                            {
                                tabDessin[cpt*2  ] = tabDessin[(cpt-1)*2  ];
                                tabDessin[cpt*2+1] = tabDessin[(cpt-1)*2+1];
                            }
                            else
                            {
                                tabDessin[cpt*2  ] = (tabDessin[(cpt-1)*2] == VAL_BAS + VAL_DROITE ? VAL_HAUT : VAL_BAS) + VAL_DROITE;
                                //tabDessin[cpt*2+1] = tabDessin[(cpt-1)*2+1] == ;
                            }
                        }

                        if (suivant == '0')
                            tabDessin[cpt*2+1] += VAL_DROITE;
                    }
                }
            }

            for (int i : tabDessin) System.out.print(i + " | ");

        }).start();
	}
}
