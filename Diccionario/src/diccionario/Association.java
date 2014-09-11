package diccionario;
/**
 * Esteban Barrera 13413
 * Daniel Mejia 13271
 * Diego Juarez 13280
 * Jose Sagastumen 13217
 * La clase Association<K,V> fue tomada del tema de Hastable que se subio en blackboard. 
 */
public class Association<K,V>
{
    protected K theKey; 
    protected V theValue; 
    public Association(K key, V value)
    {
        theKey = key;
        theValue = value;
    }

    public Association(K key)
    {
        this(key,null);
    }
    
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }

    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    public V getValue()
    {
        return theValue;
    }

    public K getKey()
    {
        return theKey;
    }

    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}
