package storescaxias



import org.junit.*
import grails.test.mixin.*

@TestFor(ProdutoController)
@Mock(Produto)
class ProdutoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/produto/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.produtoInstanceList.size() == 0
        assert model.produtoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.produtoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.produtoInstance != null
        assert view == '/produto/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/produto/show/1'
        assert controller.flash.message != null
        assert Produto.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/produto/list'


        populateValidParams(params)
        def produto = new Produto(params)

        assert produto.save() != null

        params.id = produto.id

        def model = controller.show()

        assert model.produtoInstance == produto
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/produto/list'


        populateValidParams(params)
        def produto = new Produto(params)

        assert produto.save() != null

        params.id = produto.id

        def model = controller.edit()

        assert model.produtoInstance == produto
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/produto/list'

        response.reset()


        populateValidParams(params)
        def produto = new Produto(params)

        assert produto.save() != null

        // test invalid parameters in update
        params.id = produto.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/produto/edit"
        assert model.produtoInstance != null

        produto.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/produto/show/$produto.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        produto.clearErrors()

        populateValidParams(params)
        params.id = produto.id
        params.version = -1
        controller.update()

        assert view == "/produto/edit"
        assert model.produtoInstance != null
        assert model.produtoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/produto/list'

        response.reset()

        populateValidParams(params)
        def produto = new Produto(params)

        assert produto.save() != null
        assert Produto.count() == 1

        params.id = produto.id

        controller.delete()

        assert Produto.count() == 0
        assert Produto.get(produto.id) == null
        assert response.redirectedUrl == '/produto/list'
    }
}
