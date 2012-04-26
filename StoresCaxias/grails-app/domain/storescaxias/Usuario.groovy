package storescaxias

class Usuario {
	String login
	String senha
	String email
	Pessoa pessoa
	
	String toString(){
		login
	}
    static constraints = {
		email(email:true, blank:false, unique:true)
		login(blank:false,unique:true)
		senha(blank:false)
		pessoa(nullable:true)
    }
}
