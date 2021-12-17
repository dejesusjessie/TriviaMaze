package model;

import java.io.Serializable;

/**
 * @author Kannika Armstrong
 * @version Fall 2021
 */

// Create Door for each room

public class Door implements Serializable{

    private boolean locked = false;
    private boolean open = false;

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    // If the door is locked
    public boolean isLocked() {
        return this.locked;
    }

    // If the door is open
    public boolean isOpen() {
        return this.open;
    }

    // Lock the door
    public void lock() {
        this.locked = true;
    }

    // Unlock the door
    public void unlock() {
        this.locked = false;
    }

    // Open the door
    public void open() {
        this.open = true;
    }

    // Close the door
    public void close() {
        this.open = false;
    }

    // The door controller
    public boolean canEnter() {
        if (this.open) {
            return true;
        }
        return !this.locked;
    }
}
