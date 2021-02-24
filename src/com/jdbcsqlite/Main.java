package com.jdbcsqlite;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try{
            Connection connect = DriverManager.getConnection("jdbc:sqlite:/Users/RZA/Desktop/mangacollectiondb/mangacollection.db");

            Statement statement = connect.createStatement();
            statement.execute("create table if not exists genre(number integer primary key, type text)");
            statement.execute("create table if not exists manga(title text, volume text, author text, publisher text, genre text, foreign key(genre) references genre(number))");

//            statement.execute("insert into genre values(1, 'Horror')");
//            statement.execute("insert into genre values(2, 'Fantasy')");
//            statement.execute("insert into genre values(3, 'Action')");
//            statement.execute("insert into genre values(4, 'Drama')");


//            statement.execute("insert into manga values('Deathnote', 'Volumes 1-13' ,'Takeshi Obata', 'VIZ BOOKS', 3)");
//            statement.execute("insert into manga values('Tokyo Ghoul', 'Volumes 1-14' ,'Sui Ishida', 'VIZ BOOKS', 3)");
//            statement.execute("insert into manga values('Attack on Titan', 'Season 1 Part 1' ,'Hajime Isayama', 'KODANSHA COMICS', 3)");
//            statement.execute("insert into manga values('One Piece', 'Volumes 1-23' ,'Eiichiro Oda', 'VIZ BOOKS', 2)");
//            statement.execute("insert into manga values('Dragon Ball', 'Volumes 1-16' ,'Akira Toriyama', 'VIZ BOOKS', 2)");
//            statement.execute("insert into manga values('No Longer Human', 'Single' ,'Junji Ito', 'VIZ BOOKS', 1)");
//            statement.execute("insert into manga values('Smashed', 'Single' ,'Junji Ito', 'VIZ BOOKS', 1)");
//            statement.execute("insert into manga values('Dissolving Classroom', 'Single' ,'Junji Ito', 'VIZ BOOKS', 1)");
//            statement.execute("insert into manga values('A Silent Voice', 'Volumes 1-7' ,'Yoshitoki Oima', 'KODANSHA COMICS', 1)");
//            statement.execute("insert into manga values('Fullmetal Alchemist', 'Volumes 1-27' ,'Hiromu Arakawa', 'VIZ BOOKS', 3)");
//            statement.execute("insert into manga values('Dr. STONE', 'Volumes 1-5' ,'Riichiro Inagaki', 'VIZ BOOKS', 2)");
//            statement.execute("insert into manga values('Deadman Wonderland', 'Volumes 1-9' ,'Jinsei Kataoka', 'VIZ BOOKS', 1)");
//            statement.execute("insert into manga values('Goodnight Punpun', 'Volumes 1-7' ,'Inio Asano', 'VIZ BOOKS', 4)");
//            statement.execute("insert into manga values('Bakuman', 'Volumes 1-20' ,'Takeshi Obata', 'VIZ BOOKS', 4)");
//            statement.execute("insert into manga values('Parasyte', 'Volumes 1-7' ,'Hitoshi Iwaaki', 'KODANSHA COMICS', 1)");
//            statement.execute("insert into manga values('Blade of the Immortal', 'Volumes 1-8' ,'Hiroaki Samura', 'DARK HORSE MANGA', 4)");
//            statement.execute("insert into manga values('GIGANT', 'Volumes 1-5' ,'Hiroya Oku', 'SEVEN SEAS', 4)");
//            statement.execute("insert into manga values('Blood on the Tracks', 'Volumes 1' ,'Shuzo Oshimi', 'VERTICAL', 4)");
//            statement.execute("insert into manga values('Flowers of Evil', 'Volumes 1-3' ,'Shuzo Oshimi', 'VERTICAL', 4)");
//            statement.execute("insert into manga values('At the Mountains of Madness', 'Volumes 1-2' ,'Gou Tanabe', 'DARK HORSE MANGA', 1)");
//            statement.execute("insert into manga values('Black Torch', 'Volumes 1-5' ,'Tsuyoshi Takaki', 'VIZ BOOKS', 3)");
//            statement.execute("insert into manga values('Black Bird', 'Volumes 1-18' ,'Kanoko Sakurakouji', 'SHOJO BEAT', 4)");

            statement.execute("select * from manga");

            ResultSet results = statement.getResultSet();
            while(results.next()){
                System.out.println(results.getString("title") + " - " + results.getString("volume") + " - " + results.getString("author") +
                        " - " + results.getString("publisher") + " - " + results.getString("genre"));
            }

            results.close();

            statement.close();
            connect.close();

        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
