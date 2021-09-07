package application.module;

import application.database.DataBaseEngine;
import application.database.HandleImageInMySQL;
import application.database.TryWritingToDataBase;
import application.model.Courses;
import application.model.Members;
import application.model.State;
import application.model.Subjects;
import application.util.Print;

import java.util.List;

public class Processor {

    public Processor() {
    }

    public void run() {
        // connection for existing DataBase!

        DataBaseEngine dataBaseEngine = new DataBaseEngine(); // should connect

        Print print = new Print();

        System.out.println(dataBaseEngine.isConnected());
        // System.out.println(System.getenv()); // watch out! writes your password from environment!
        // System.out.println(System.getenv("DATABASE_USER")); // gives back the user!
        // System.out.println(System.getenv("DATABASE_PASSWORD")); // prints the password of the user!

        if (dataBaseEngine.isConnected()) {
            List<Members> membersList = dataBaseEngine.listAllMembers();
            System.out.println(membersList.toString());
        } else {
            System.out.print("There is no connection to database!");
        }

        if (dataBaseEngine.isConnected()) {
            Members members = dataBaseEngine.findMembersByName("'Csaba'"); // watch out double quotation mark!
            System.out.println(members);
        } else {
            System.out.println("There is no connection to database!");
        }
        if (dataBaseEngine.isConnected()) {
            Members members = dataBaseEngine.findMembersByNameAnotherWay("Csaba"); // watch out no need extra quotation mark!
            System.out.println(members);
        } else {
            System.out.println("There is no connection to database!");
        }

        if (dataBaseEngine.isConnected()) {
            Subjects subjects = dataBaseEngine.findSubjectsByName("Bootstrap");
            System.out.println(subjects);
        } else {
            System.out.println("There is no connection to database!");
        }

        if (dataBaseEngine.isConnected()) {
            List<Courses> coursesList = dataBaseEngine.findMembersToCourses(1);
            System.out.println(coursesList);
        } else {
            System.out.println("There is no connection to database!");
        }

        State state = State.STAFF;
        System.out.println("Checking index of staff: " + state.getMySQLIndexFromJavaIndex());

        new TryWritingToDataBase().tryAddANewMemberToDataBase();

        // here bellow you may find the new added person to Members!
        if (dataBaseEngine.isConnected()) {
            List<Members> membersList = dataBaseEngine.listAllMembers();
            System.out.println(membersList);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("New query with the new way:");

        if (dataBaseEngine.isConnected()) {
            Members members = dataBaseEngine.findMemberByNameWithBuilder("Csaba");
            System.out.println(members);
        }

        if (dataBaseEngine.isConnected()) {
            boolean isSuccess = new HandleImageInMySQL().addPhoto(new Members());
            System.out.println("The picture upload was success: " + isSuccess);
        }

        if (dataBaseEngine.isConnected()) {
            List<Members> membersList = dataBaseEngine.listAllMembers();
            System.out.println(membersList);
        }
    }
}