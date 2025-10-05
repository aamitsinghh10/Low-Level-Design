public class Permission {
    private boolean canRead;
    private boolean canWrite;
    private boolean canDelete;

    public Permission(boolean canRead, boolean canWrite, boolean canDelete) {
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canDelete = canDelete;
    }
    public boolean checkRead() {
        return canRead;
    }
    public boolean checkWrite() {
        return canWrite;
    }
    public boolean checkDelete() {
        return canDelete;
    }
}
