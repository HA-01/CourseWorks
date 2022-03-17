public class Patient {
    private double patientAge;
    private String firstName;
    private String surName;
    private String cityOfThePatient;
    private String NIC_or_passport_num;


    public String getFirstName() {                                        //getters and setters
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;

    }

    public double getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(double patientAge) {
        this.patientAge = patientAge;
    }

    public String getCityOfThePatient() {
        return cityOfThePatient;
    }

    public void setCityOfThePatient(String cityOfThePatient) {
        this.cityOfThePatient = cityOfThePatient;
    }


    public String getNIC_or_passport_num() {
        return NIC_or_passport_num;
    }


    public void setNIC_or_passport_num(String NIC_or_passport_num) {
        this.NIC_or_passport_num = NIC_or_passport_num;
    }
}
