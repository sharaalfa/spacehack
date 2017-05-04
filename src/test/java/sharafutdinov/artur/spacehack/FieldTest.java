package sharafutdinov.artur.spacehack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by first on 03.05.17.
 */
class FieldTest {
    @Test
    void equalsAppStore() {

        assertEquals(true, new Field().equalsAppStore("1234", "1234"));
        assertEquals(true, new Field().equalsAppStore("sadae", "gff"));
    }

}