package maze;

// Create Door for each room
// Condition to pass the door: Locked/Open - Result
// Cannot pass the door when the answer is wrong
// Can pass the door when the answer is right
// Cannot pass the door when do not answer the question yet

public class Door {

    private boolean locked = false;
    private boolean open = false;

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

    public boolean isWall() {
        return this.locked;
    }
}
