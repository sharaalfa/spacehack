package sharafutdinov.artur.spacehack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

/**
 * Created by first on 30.04.17.
 */
public class Compare {

    /**
     * Логгирование
     */

    private static Logger logger = Logger.getLogger(Compare.class);

    /**
     * Результат сравнения двух csv  файлов по уникальным subUID
     * для соединения данных по гендерным различичиям и тестовым показателям
     */

    HashMap<String, String> map = new HashMap<>();

    /**
     * Инициализациия
     */

    static {
        PropertyConfigurator.configure(
                "/home/first/Yandex.Disk/Java_study/spacehack/src/main/resources/log4j.xml");
    }


    /**
     * Добавляем subUID для сравнения
     */
    public synchronized void add(String subUID, String subUID2) {

    }

}
