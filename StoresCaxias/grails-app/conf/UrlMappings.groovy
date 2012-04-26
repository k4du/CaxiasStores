class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/"(controller : "usuario", action:"login")
		"500"(view:'/error')
	}
}
