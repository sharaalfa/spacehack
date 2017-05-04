package sharafutdinov.artur.spacehack;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by first on 29.04.17.
 */
public class ReadXMLProSubusers {

    /**
     * Логгирование
     */
    private static  final Logger logger = Logger.getLogger(ReadXMLProSubusers.class);

    public  void saveToDB (
            String login, String password,
            String database, String table,
            String column, String fileName,
            int startWith, int serialNumber,
            int amount) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Нет драйвера");
        }

        /**
         * запуск скаченного Ignite и
         * сохранение полученных значений парсинга
         * в созданную базу данных
         */

        try (Ignite ignite = Ignition.start(
                "/home/first/Desktop/apache-ignite-fabric-1.9.0-bin/examples/config/example-ignite.xml")) {
            IgniteCache<String, String> cache = ignite.getOrCreateCache("myCache");

            Connection connection = getConPostgres(login, password, database);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO " + table + "(subuid, " + column + ")" + "VALUES (?, ?) ");
            try {
                /**
                 * Объектная модель исходного файла XML
                 */
                final File xmlFile = new File(System.getProperty("user.dir")
                        + File.separator + fileName);

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(xmlFile);

                /**
                 * нормализация
                 */
                doc.getDocumentElement().normalize();

                /**
                 * получаем все узлы с именем "column"
                 * и путем итераций записываем значения определенной колонки
                 * с уникальным UID-ом пользователя
                 */
                NodeList nodeList = doc.getElementsByTagName("column");
                int j;
                for (int i = startWith; i < 500000; ++i) {
                    i += serialNumber;
                    j = i + amount;
                    Element field = (Element) nodeList.item(i);
                    Element field1 = (Element) nodeList.item(j);
                    String valEl = field.getTextContent();
                    String valUID = field1.getTextContent();
                    cache.put(valUID, valEl);
                    preparedStatement.setString(1, valUID);
                    preparedStatement.setString(2, valEl);
                    preparedStatement.executeUpdate();
                }



            } catch (NullPointerException e) {
                logger.trace("Я здесь не виноват!");

            } catch (ParserConfigurationException e) {
                logger.trace("проблемы с парсингом");
            } catch (SAXException e) {
                logger.trace("ошибка в чтении XML");
            } catch (IOException e) {
                logger.error("ошибки");
            }
        } catch (IgniteException e) {
            logger.error("ошибки Игната!");

        } catch (SQLException e) {
            logger.error("ошибки с соединения с бд");
        }

}

    public static Connection getConPostgres(String user, String password, String database)
            throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/"
                + database, user, password);
    }





}
