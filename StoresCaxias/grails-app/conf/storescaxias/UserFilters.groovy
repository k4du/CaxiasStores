package storescaxias

class UserFilters {

	def filters = {
		all(controller:'*', action:'*') {
			
			before = {
//				if(actionName == 'index'){
//					return true
//				}
//				
//				if(controllerName == "usuario" && actionName == 'create'){
//					return true
//				}
//				if(controllerName == "usuario" && actionName == 'save'){
//					return true
//				}
//				
//				
//				
//				if(controllerName == "usuario" && actionName == 'login'){
//					return true
//				}else{
//					
//					if(session.usuario){
//						return true
//					}else{
//						redirect(controller:'usuario', action:'login');
//						return false
//					}
//				}
//								
			}
			after = { Map model ->

			}
			afterView = { Exception e ->

			}
		}
	}
}