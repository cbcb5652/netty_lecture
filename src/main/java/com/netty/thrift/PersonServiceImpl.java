package com.netty.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/22 16:48
 * @Version V1.0
 **/

public class PersonServiceImpl implements PersonService.Iface {


    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
       System.out.println("Got Client Param:"+username);

       Person person = new Person();

       person.setUsername(username);
       person.setAge(20);
       person.setMarried(false);

       return person;
    }



    @Override
    public void savePerson(Person person) throws DataException, TException {

        System.out.println("Go client Param:");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());

    }
}
