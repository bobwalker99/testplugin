package uk.co.bobwalker.minecraft.plugins.fatduckplugin.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.Command;

public class CommandTest {

    @Test
    public void testBurn() {
        this.testBurn("burn");
    }

    @Test
    public void testMixedCase() {
        this.testBurn("bUrN");
    }

    @Test
    public void testUpperCase() {
        this.testBurn("BURN");
    }

    private void testBurn(String test) {
        // When
        Command command = Command.fromString(test);

        // Then
        assertEquals(Command.BURN, command);
    }
}
