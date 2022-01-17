package contactdata;

public class Contacts {

    public String firstName, lastName, address, city, state, email, zip, mobNo;

    @Override
    public String toString()
    {
        return " { " +
                " FirstName = " + firstName +
                ", LastName = " + lastName +
                ", Address = " + address +
                ", City = " + city +
                ", State = " + state +
                ", Email = " + email +
                ", Zip = " + zip +
                ", MobNo = " + mobNo +
                " }";
    }

}
