
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	private String parentField;

	public Parent(final String parentField) {
		this.parentField = parentField;
	}

	@Override
	public String toString() {
		return "Parent{" + "parentField='" + parentField + '\'' + '}';
	}
}

class Child extends Parent {
	private static final long serialVersionUID = 1L;

	private String childField;

	public Child(final String parentField, final String childField) {
		super(parentField);
		this.childField = childField;
	}

//	private void writeObject(final ObjectOutputStream oos) throws IOException {
//		throw new NotSerializableException("Serialization is not allowed for this class.");
//	}
//
//	private void readObject(final ObjectInputStream ois) throws IOException {
//		throw new NotSerializableException("Deserialization is not allowed for this class.");
//	}

	@Override
	public String toString() {
		return "Child{" + "childField='" + childField + '\'' + "} " + super.toString();
	}
}

public class SerializationDemo {
	public static void main(final String[] args) {
		final Child child1 = new Child("ParentField", "ChildField");
		final Parent child = new Parent("ParentField");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("child.ser"))) {
			oos.writeObject(child);
		} catch (final IOException e) {
			System.out.println("Exception during serialization: " + e);
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("child.ser"))) {
			final Parent deserializedChild = (Parent) ois.readObject();
			System.out.println("Deserialized Child: " + deserializedChild);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Exception during deserialization: " + e);
		}
	}
}
