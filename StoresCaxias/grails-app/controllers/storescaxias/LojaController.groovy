package storescaxias

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

class LojaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
		if(params.id){
			def ramo = Ramo.findById(params.id)
			println ramo.lojas
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[lojaInstanceList: ramo.lojas, lojaInstanceTotal: ramo.lojas.size()]
		}else{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[lojaInstanceList: Loja.list(params), lojaInstanceTotal: Loja.count()]
		}
        
    }

    def create() {
        [lojaInstance: new Loja(params)]
    }

    def save() {
        def lojaInstance = new Loja()
		lojaInstance.properties = params
		println params 
		if(request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			CommonsMultipartFile file = (CommonsMultipartFile)multiRequest.getFile("imagem");
			lojaInstance.imagem = file.bytes // screenshot is the image blob field of the record
		}
		if(params.ramo.id){
			lojaInstance.ramo = Ramo.findById(params.ramo.id)
    	}
        if (!lojaInstance.save(flush: true)) {
            render(view: "create", model: [lojaInstance: lojaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'loja.label', default: 'Loja'), lojaInstance.id])
        redirect(action: "show", id: lojaInstance.id)
    }

    def show() {
        def lojaInstance = Loja.get(params.id)
        if (!lojaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
            redirect(action: "list")
            return
        }

        [lojaInstance: lojaInstance]
    }

    def edit() {
        def lojaInstance = Loja.get(params.id)
        if (!lojaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
            redirect(action: "list")
            return
        }

        [lojaInstance: lojaInstance]
    }

    def update() {
        def lojaInstance = Loja.get(params.id)
        if (!lojaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (lojaInstance.version > version) {
                lojaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'loja.label', default: 'Loja')] as Object[],
                          "Another user has updated this Loja while you were editing")
                render(view: "edit", model: [lojaInstance: lojaInstance])
                return
            }
        }

        lojaInstance.properties = params

        if (!lojaInstance.save(flush: true)) {
            render(view: "edit", model: [lojaInstance: lojaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'loja.label', default: 'Loja'), lojaInstance.id])
        redirect(action: "show", id: lojaInstance.id)
    }
	def mostrarImagem = {
		def lojaInstance = Loja.get( params.id)
		byte[] image = lojaInstance.imagem
		response.outputStream << image
	}
	
    def delete() {
        def lojaInstance = Loja.get(params.id)
        if (!lojaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
            redirect(action: "list")
            return
        }

        try {
            lojaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
