package TP1;

public enum TypeSignal
{
    NRZ(0),
    MANCHESTER(1),
    MANCHESTER_DIFF(2),
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
            case 2 -> res = "Machester Différentiel";
            case 3 -> res = "Miller";
        }

        return res;
    }
}
