package TP1;

/**
 * The enum Type signal.
 */
public enum TypeSignal
{
    /**
     * Nrz type signal.
     */
    NRZ(0),
    /**
     * Manchester type signal.
     */
    MANCHESTER(1),
    /**
     * Manchester diff type signal.
     */
    MANCHESTER_DIFF(2),
    /**
     * Miller type signal.
     */
    MILLER(3);

    private final int type;

    TypeSignal(int type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        String res = "";

        switch (this.type)
        {
            case 0 -> res = "NRZ";
            case 1 -> res = "Manchester";
            case 2 -> res = "Manchester Différentiel";
            case 3 -> res = "Miller";
        }

        return res;
    }
}
