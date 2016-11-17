package com.realcomp.names;


public class Name{

    /*
     * Previously, this class was an interface, with two implementers:
     * IndividualName and CompanyName.
     *
     * CompanyName was a simple class that wrapped a single String.
     * IndividualName was effectively this class.
     *
     * The two classes were combined to make serialization
     * of Names a bit easier. In a Property object, there are multiple names,
     * and it is cleaner to have a single class for each. Descisions
     * on Name.isComanyName() are much cleaner and portable than
     * Name instanceof CompanyName.
     *
     */
    private boolean companyName;
    private String prefix;
    private String first;
    private String middle;
    private String last;
    private String suffix;

    public Name(){
    }

    public Name(String companyName){
        this.companyName = true;
        this.last = companyName;
    }

    public Name(Name copy){
        this.prefix = copy.prefix;
        this.first = copy.first;
        this.middle = copy.middle;
        this.last = copy.last;
        this.suffix = copy.suffix;
        this.companyName = copy.companyName;
    }

    public boolean isCompanyName(){
        return companyName;
    }

    public void setCompanyName(boolean companyName){
        this.companyName = companyName;
    }

    public String getFirst(){
        return first;
    }

    public void setFirst(String first){
        this.first = first;
    }

    public boolean hasFirst(){
        return first != null && !first.isEmpty();
    }

    public String getLast(){
        return last;
    }

    public void setLast(String last){
        this.last = last;
    }

    public boolean hasLast(){
        return last != null && !last.isEmpty();
    }

    public String getMiddle(){
        return middle;
    }

    public void setMiddle(String name){
        this.middle = name;
    }

    public boolean hasMiddle(){
        return middle != null && !middle.isEmpty();
    }

    public void addMiddle(String name){
        middle = middle == null ? name : middle.concat(" ").concat(name);
    }

    public String getPrefix(){
        return prefix;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public boolean hasPrefix(){
        return prefix != null && !prefix.isEmpty();
    }

    public String getSuffix(){
        return suffix;
    }

    public void setSuffix(String suffix){
        this.suffix = suffix;
    }

    public boolean hasSuffix(){
        return suffix != null && !suffix.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        if (hasPrefix()){
            s.append(prefix).append(" ");
        }
        if (hasFirst()){
            s.append(first).append(" ");
        }
        if (hasMiddle()){
            s.append(middle).append(" ");
        }
        if (hasLast()){
            s.append(last).append(" ");
        }
        if (hasSuffix()){
            s.append(suffix);
        }
        return s.toString().trim();
    }


    @Override
    public int hashCode(){
        int hash = 3;
        hash = 11 * hash + (this.companyName ? 1 : 0);
        hash = 11 * hash + (this.prefix != null ? this.prefix.hashCode() : 0);
        hash = 11 * hash + (this.first != null ? this.first.hashCode() : 0);
        hash = 11 * hash + (this.middle != null ? this.middle.hashCode() : 0);
        hash = 11 * hash + (this.last != null ? this.last.hashCode() : 0);
        hash = 11 * hash + (this.suffix != null ? this.suffix.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Name other = (Name) obj;
        if (this.companyName != other.companyName){
            return false;
        }
        if ((this.prefix == null) ? (other.prefix != null) : !this.prefix.equals(other.prefix)){
            return false;
        }
        if ((this.first == null) ? (other.first != null) : !this.first.equals(other.first)){
            return false;
        }
        if ((this.middle == null) ? (other.middle != null) : !this.middle.equals(other.middle)){
            return false;
        }
        if ((this.last == null) ? (other.last != null) : !this.last.equals(other.last)){
            return false;
        }
        if ((this.suffix == null) ? (other.suffix != null) : !this.suffix.equals(other.suffix)){
            return false;
        }
        return true;
    }
}
