class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/"(controller : "loja", action:"list")
		"500"(view:'/error')
	}
}
