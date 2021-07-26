package Utils.ParsePackage.Adapters;

import Entities.OrgStuff.Person;
import Utils.ParsePackage.AdaptedPerson;

import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 * PersonAdapter нужен для преобразования AdaptedPerson в Person.
 */
public class PersonAdapter extends XmlAdapter<AdaptedPerson, Person> {

    /**
     * При операции unmarshall AdaptedPerson передается в эту функцию и вызывается конструктор Person на основне полей AdaptedPerson
     * @param v - AdaptedPerson
     * @return Person
     * @throws Exception
     */
    @Override
    public Person unmarshal(AdaptedPerson v) throws Exception {
        return new Person(v.getName(), v.getSurname(), v.getPatronymic(), v.getPosition(), v.getBirthDate(), v.getPhoneNumber());
    }

    @Override
    public AdaptedPerson marshal(Person v) throws Exception {
        return null;
    }
}
