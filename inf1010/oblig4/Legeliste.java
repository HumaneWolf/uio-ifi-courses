class Legeliste extends OrdnetLenkeliste<Lege> {
    /**
     * Soeker gjennom listen etter en lege med samme navn som `navn`
     * og returnerer legen (uten aa fjerne den fra listen).
     * Hvis ingen slik lege finnes, returneres `null`.
     * @param   navn    navnet til legen
     * @return  legen
     */
    public Lege finnLege(String navn) {
        //To access the iterator from the superclass.
        OrdnetLenkelisteIterator<Lege> iterator = new OrdnetLenkelisteIterator<Lege>(super.start);
        Lege l = null;
        while (iterator.hasNext()) {
            l = iterator.next();
            if (navn.equalsIgnoreCase(l.hentNavn())) {
                return l;
            }
        }
        return null;
    }

    /**
     * Returnerer et String[] med navnene til alle legene i listen
     * i samme rekkefoelge som de staar i listen.
     * @return array med navn til alle legene
     */
    public String[] stringArrayMedNavn() {
        int count = super.storrelse();
        String[] output = new String[count];
        int i = 0;

        //Again to access the iterator.
        OrdnetLenkelisteIterator<Lege> iterator = new OrdnetLenkelisteIterator<Lege>(super.start);
        Lege l = null;
        while (iterator.hasNext()) {
            l = iterator.next();
            output[i] = l.hentNavn();
            i++;
        }
        return output;
    }
}