package jarvis.analysis;

import java.util.ArrayList;
import java.util.List;

public class ClassMeta {

    private Meta packageMeta;

    private List<Meta> importMeta;

    private String visibility;

    private boolean isAbstract;

    private String className;

    private String classType;

    private List<ClassElementMeta> fields;

    private List<ClassElementMeta> methods;

    public ClassMeta() {
        importMeta = new ArrayList<>();
        fields = new ArrayList<>();
        methods = new ArrayList<>();
    }

    public Meta getPackageMeta() {
        return packageMeta;
    }

    public void setPackageMeta(Meta packageMeta) {
        this.packageMeta = packageMeta;
    }

    public List<Meta> getImportMeta() {
        return importMeta;
    }

    public void setImportMeta(List<Meta> importMeta) {
        this.importMeta = importMeta;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ClassElementMeta> getFields() {
        return fields;
    }

    public void setFields(List<ClassElementMeta> fields) {
        this.fields = fields;
    }

    public List<ClassElementMeta> getMethods() {
        return methods;
    }

    public void setMethods(List<ClassElementMeta> methods) {
        this.methods = methods;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
