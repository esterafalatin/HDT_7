package diccionario;
/**
 * Esteban Rafael Barrera   - 13413
 * Jorge Daniel Mejia       - 13271
 * Diego Alejandro Juarez   - 13280
 * Jose Alejandro Sagastume - 13217
 * @param <E>
 */

// Implementacion de la Clase BinaryTree para hacer las operaciones de un arbol Binario
// Codigo Tomado del libro 

public class BinaryTree<E>
{
    protected E val; 
    protected BinaryTree<E> parent; 
    protected BinaryTree<E> left, right; 
    
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right, BinaryTree<E> parent){
        val=value;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }
    
    public BinaryTree<E> left()

    {
            return left;
    }

    public BinaryTree<E> right()

    {
            return right;
    }

    public BinaryTree<E> parent()

    {
        return parent;
    }
    
    public void setLeft(BinaryTree<E> newLeft){
        this.left=newLeft;
    }
    
    public void setRight(BinaryTree<E> newRight){
        this.right=newRight;
    }
    
    public void setParent(BinaryTree<E> newParent){
        this.left=newParent;
    }
    
    public E value()

	{
		return val;
	}
	
	public void setValue(E value)

	{
		val = value;
	}
    
}