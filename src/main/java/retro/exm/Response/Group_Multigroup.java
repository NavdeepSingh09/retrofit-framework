package retro.exm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Group_Multigroup {

    @SerializedName("groups")
    @Expose
    private List<Group> groups = null;
    @SerializedName("multigroups")
    @Expose
    private List<Multigroup> multigroups = null;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Multigroup> getMultigroups() {
        return multigroups;
    }

    public void setMultigroups(List<Multigroup> multigroups) {
        this.multigroups = multigroups;
    }
}
