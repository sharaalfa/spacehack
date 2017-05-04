package sharafutdinov.artur.spacehack;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by first on 29.04.17.
 */
public class Field {
    private volatile boolean aBoolean;

    /**
     * Логгирование
     */

    private  static final Logger logger = Logger.getLogger(Field.class);

    public boolean equalsAppStore (String data, String data1) {

        try {
            if (data.equalsIgnoreCase(data1)) {
                aBoolean = true;
                return aBoolean;

            } else {
                aBoolean = false;
                return aBoolean;
            }

        } catch (Exception e) {
            logger.trace("проблема в " +
                    "итерации по символам");
        } return aBoolean;

    }



}
