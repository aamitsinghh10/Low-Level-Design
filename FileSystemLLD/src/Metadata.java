import java.util.*;
public class Metadata {
    private long size;
    private Date createdAt;
    private Date updatedAt;
    private Permission permissions;
    public Metadata() {
        this.size = 0;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.permissions = new Permission(true, true, true); // default full permissions
    }
    public long getSize() {return size;}
    public void setSize(long size) {this.size = size;}
    public Date getCreatedAt() {return createdAt;}
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}
    public Permission getPermissions() {return permissions;}

    public void setPermissions(Permission permissions) {this.permissions = permissions;}
}
