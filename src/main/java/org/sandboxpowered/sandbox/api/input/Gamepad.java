package org.sandboxpowered.sandbox.api.input;

import com.google.common.annotations.Beta;

@Beta
public interface Gamepad extends InputDevice {

    /**
     * Gets the stick's axis value, returns 0 if is within deadzone configuration of client.
     *
     * Always returns 0 or 1 if controller does not support pressure detection
     *
     * @return The value (0-1) that the stick has moved along the axis after deadzone checking
     */
    float getAxis(Side side, Axis axis);

    /**
     * Gets the trigger's activation value, returns 0 if is within deadzone configuration of client.
     *
     * Always returns 0 or 1 if controller does not support pressure detection
     *
     * @return The value (0-1) corresponding to the pressure of the trigger
     */
    float getTrigger(Side side);

    /**
     * Checks whether the button is currently pressed on the gamepad
     *
     * Returns false if button doesn't exist on gamepad
     */
    boolean isDown(Button button);

    /**
     * Checks whether the buttons are currently pressed on the gamepad
     *
     * Ignores buttons if they dont exist on gamepad
     */
    boolean areDown(Button... buttons);

    enum Side {
        LEFT,
        RIGHT
    }

    enum Axis {
        X,
        Y,
    }

    enum Button {
        A,
        B,
        X,
        Y,
        START,
        MENU,
        LEFT_BUMPER,
        RIGHT_BUMPER,
        DPAD_UP,
        DPAD_DOWN,
        DPAD_LEFT,
        DPAD_RIGHT,
        LEFT_STICK,
        RIGHT_STICK
    }
}