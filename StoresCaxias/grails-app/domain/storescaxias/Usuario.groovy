package storescaxias

class Usuario {
	String login
	String senha
	String email
	static belongsTo = [loja:Loja]
	
	String toString(){
		login
	}
    static constraints = {
		email(email:true, blank:false, unique:true)
		login(blank:false,unique:true)
		senha(blank:false)
    }
}
