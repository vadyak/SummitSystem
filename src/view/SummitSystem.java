/*
    Проект №7. Система для выбора проведения места саммита
    Реализация проекта(с использованием базы данных).
    Регистрация нового пользователя проходит при помощи метода registration(), после успешной авторизации с помощью
метода authorization() - возвращается объект, у которого можно вызывать метод создания нового предложения
проведения саммита addRequest(). Это сделано чтобы исключить возможность созданий новых предложений без аутентификации.
    Предусмотрена возможность добавления одним пользователем нескольких варинтов одной страны и одного месяца, но разных
промежутков времени. Итоговый вариант получается посредством сравнения матриц дат месяца с помощью побитовой операции '&'

Для работы проекта необходимо создать схему и 2 таблицы
CREATE SCHEMA `summitsystemdb` ;

CREATE TABLE users
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE request
(
    leaderID INT NOT NULL,
    country VARCHAR(255) NOT NULL,
    month INT NOT NULL,
    interval VARCHAR(255) NOT NULL
);

comment**
1.
    Нет четко выраженной структуры приложения. Нет разбиения по пакетам согласно логической структуре.
    Можете почитать про трехуровневую организацию приложений, где выделяют слои view-service-persistence.
    persistence - это ваш DAO - он у вас размазан по всем классам
    service - это бизнес логика
    view - ваш интерфейс по взаимодействию с пользователем.
    Далее структурируйте проект по пакетам, согласно указанной выше организации.
    Ваши классы Leader и Admin вообще не должны напрямую обращаться к базе данных. Допустим, если надо проверить пароль
админа view вызывает метод Admin-а далее этот метод обращается к методу уровня сервиса, сервис готовит запрос к ДАО,
а уже ДАО вытягивает из БД значение пароля для проверки на уровне сервиса.
*/
package view;

import model.Admin;
import model.Leader;
import model.SearchGlobalVariant;

import java.sql.SQLException;

public class SummitSystem {
    public static void main(String[] args) throws SQLException {
//        Leader.registration("Vadim", "vasos", "2239");
//        Leader.registration("Vadim", "vasos1", "2239");
//        Leader.registration("Vadim", "vasos2", "2239");
//        Leader.registration("Vadim", "vasos3", "2239");
//        Admin.registration("admin", "admin1", "1111");
//
//        Leader leader = Leader.authorization("vasos", "2239");
//        Leader leader2 = Leader.authorization("vasos1", "2239");
//        Leader leader3 = Leader.authorization("vasos2", "2239");
//        Leader leader4 = Leader.authorization("vasos3", "2239");
//        Admin admin = Admin.authorization("admin1", "1111");
//
//        leader.addRequest("Belarus", 1, 1, 15);
//        leader.addRequest("Belarus", 1, 16, 19);
//        leader.addRequest("Romania", 11, 1, 13);
//        leader.addRequest("Russia", 6, 3, 15);
//        leader.addRequest("Romania", 2, 17, 19);
//        leader.addRequest("Romania", 11, 17, 19);
//        leader.addRequest("Sweden", 2, 1, 2);
//
//        leader2.addRequest("Russia", 6, 3, 4);
//        leader2.addRequest("Belarus", 1, 1, 3);
//        leader2.addRequest("Belarus", 1, 17, 17);
//        leader2.addRequest("Belarus", 1, 5, 7);
//        leader2.addRequest("Belarus", 1, 9, 12);
//        leader2.addRequest("Belarus", 1, 30, 31);
//        leader2.addRequest("Romania", 11, 1, 15);
//        leader2.addRequest("Russia", 6, 14, 15);
//        leader2.addRequest("Sweden", 2, 3, 4);
//
//        leader3.addRequest("Romania", 11, 15, 19);
//        leader3.addRequest("Belarus", 1, 1, 3);
//        leader3.addRequest("Belarus", 1, 17, 18);
//        leader3.addRequest("Russia", 6, 3, 5);
//        leader3.addRequest("Russia", 6, 15, 15);
//        leader3.addRequest("Sweden", 2, 5, 6);
//
//        leader4.addRequest("Sweden", 9, 15, 19);
//        leader4.addRequest("Belarus", 1, 2, 3);
//        leader4.addRequest("Zimbabve", 11, 17, 18);
//        leader4.addRequest("Russia", 6, 4, 4);
//        leader4.addRequest("Russia", 6, 14, 15);
//        leader4.addRequest("Sweden", 2, 7, 8);
//
//        admin.removeLeader("vasos3");//удаление пользователя

        SearchGlobalVariant searchGlobalVariant = new SearchGlobalVariant();
        searchGlobalVariant.search();//поиск вариантов мест проведения саммита
    }
}











