package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Mario
 *
 */
public class Agenda {
	
	//CheckButton que indique si la búsqueda ha de estar contenida o ser el resultado literal
	private Map<Long,String> contactos;

	public Agenda() {
		this.contactos = new HashMap<Long, String>();
	}

	public void addContact(Contacto contact) {
		this.contactos.put(contact.getPhoneNumber(), contact.getName());
	}

	public Contacto buscar(Long telefono) {
		Contacto contactoEncontrado=null;
		String nombre;
//		se crean dos metodos con el mismo nombre y entra un parametro diferente en cada uno
		// en uno se mete un string (el nombre) y en otro un long que es el numero
		//en el metodo despues se creara el contacto
		
//		Contact contactFound = null;
//		String contactName=null;	
		if ((nombre = contactos.get(telefono)) != null) {
			contactoEncontrado = new Contacto(telefono,nombre);
									// filtrar en bucle por valor para que si
										// se repite el valor o key ponerlo
										// tb.(en busqueda por valor)
										//Keys cannot be duplicated
		}

		return contactoEncontrado;
	}
	//Filtrar búsqueda mediante this.radiobutton.isSelected();
	public ArrayList<Contacto> buscar(String nombre){
		ArrayList<Contacto> contactosEncontrados= new ArrayList<Contacto>();
		
		//Extraer con hashmap.values() Una collection de values e iterar con cada uno de los valores, el hashmap
		
		for(Map.Entry<Long, String> entry : contactos.entrySet()){
			if(entry.getValue().equals(nombre)){
				contactosEncontrados.add(new Contacto(entry.getKey(),entry.getValue()));
			}
		}
		if(contactosEncontrados.size()>0){
			return contactosEncontrados;
		}else{
			return null;
		}
		
	}

	public void updateContact(Contacto contacto,Long telefono) {
		this.contactos.remove(contacto.getPhoneNumber());
		this.contactos.put(telefono, contacto.getName());
	}

	public void deleteContactByNumber(String phoneNumber) {
		this.contactos.remove(phoneNumber);
	}
	public void deleteContactByName(String contactName){
		for(Map.Entry<Long, String> entry : contactos.entrySet()){
			if(entry.getValue().equals(contactName)){
				this.contactos.remove(entry.getKey());
			}
		}
	}
}
