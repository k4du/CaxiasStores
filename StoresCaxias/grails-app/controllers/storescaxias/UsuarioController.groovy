package storescaxias

import org.springframework.dao.DataIntegrityViolationException

import storescaxias.Pessoa;
import storescaxias.Usuario;

class UsuarioController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def usuarioService
    def index() {
        redirect(action: "login", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [usuarioInstanceList: Usuario.list(params), usuarioInstanceTotal: Usuario.count()]
    }

    def create() {
		flash.message = null
        [usuarioInstance: new Usuario(params)]
    }

    def save() {
		def pessoaInsatence = new Pessoa(params)
		def usuarioInstance = new Usuario(params)
		try {
			
			usuarioService.cadastrarUsuarioPessoa(pessoaInsatence,usuarioInstance)
			flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
			redirect(action: "show", id: usuarioInstance.id)
			
		} catch (Exception e) {
			flash.message = "Error: ${e}"
			render(view: "create", model: [usuarioInstance: usuarioInstance, pessoaInsatence:pessoaInsatence ])
			return
		}
		
//		def pessoa = new Pessoa(params)
//        def usuarioInstance = new Usuario(params)
//        if (!usuarioInstance.save(flush: true)) {
//            
//            return
//        }

		
    }

    def show() {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        [usuarioInstance: usuarioInstance ]
    }

    def edit() {
        def usuarioInstance = Usuario.findById(session.usuario.id.join())
        if (!usuarioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        [usuarioInstance: usuarioInstance]
    }

    def update() {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (usuarioInstance.version > version) {
                usuarioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'usuario.label', default: 'Usuario')] as Object[],
                          "Another user has updated this Usuario while you were editing")
                render(view: "edit", model: [usuarioInstance: usuarioInstance])
                return
            }
        }
		
        usuarioInstance.properties = params
		def pessoa = new Pessoa(params)
		try{
		   	usuarioService.cadastrarUsuarioPessoa(pessoa ,usuarioInstance)
			flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
			redirect(action: "show", id: usuarioInstance.id)
		}catch (Exception e) {
			flash.message = "Erro: ${e}"
			render(view: "edit", model: [usuarioInstance: usuarioInstance])
		}
       

		
    }

    def delete() {
        
        try {
			if(session.usuario){
				usuarioService.excluirUsuario(session.usuario.id.join())
				session.removeAttribute("usuario")
				redirect(action:"login")
			}
        }
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
            redirect(action: "Login")
        }
    }
	
	def logout(){
		session.removeAttribute("usuario")
		redirect(action:"login")
	}
	
	def login(){
		if(!session.usuario){
			if(!params.login && !params.senha){
				["login" :"", "senha":""]
			}else{
				def usuario =	Usuario.withCriteria {
					eq('login', params.login)
					eq('senha', params.senha)
				}
				if(!usuario){
					flash.message = "Usuario não existente ou senha invalida"
					flash.defaultMessage = "Usuario não existente ou senha invalida"
					[nome :params.login , senha:""]
				}else{
					session.setAttribute("usuario", usuario)
					redirect(controller:'grupoConta', action:'list')
				}
			}
		}else{
			
			redirect(controller:'grupoConta', action:'list')
		}
	}
}