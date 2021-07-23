package Utils.ParsePackage.Adapters;

import Entities.Person;
import Utils.ParsePackage.AdaptedPerson;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PersonAdapter extends XmlAdapter<AdaptedPerson, Person> {


    @Override
    public Person unmarshal(AdaptedPerson v) throws Exception {
        return new Person(v.getName(), v.getSurname(), v.getPatronymic(), v.getPosition(), v.getBirthDate(), v.getPhoneNumber());
    }

    @Override
    public AdaptedPerson marshal(Person v) throws Exception {
        return null;
    }
}
