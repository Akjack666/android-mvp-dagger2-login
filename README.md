# android-mvp-dagger2-login
Ejemplo de una pantalla de Login utilizando MVP y Dagger 2, con Java


#Root

##AplicationModule

En este caso el módulo tiene la dependencia directa con la clase **Application**, la cual nos permitirá acceder al contexto de Android para sacar las dependencias necesarias del SDK.

Además tenemos el método anotado **provideContext** el cual provee de un contexto a todas aquellas clases que requieran el contexto de Android cómo dependencia.


##ApplicationComponent

El siguiente paso será el de crear un componente que incluya el módulo de Sistema que acabamos de crear y otros modulos que creemos. Un componente se define cómo una interfaz anotada con **@Component.**
A la interface , se le añadiria un Inject por cada Fragment/Activity que fuera a tener


##App

Tiene el componente principal, que instancia los modulos al iniciarse la aplicacion.
Con el metodo getComponent, podriamos acceder al componente, e inyectarle la activity/fragment


#login

##LoginActivityMVP

Interfaz con los metodos que van a necesitar la vista, el presenter y el modelo

##LoginActivity (Vista)

Solo tendremos los elementos de la vista, imprementara la interfaz anterior de vista, para tener sus metodos necesarios
Se llamara en el Oncreate al getComponent para inyectarse
El presentador se inyectara en esta clase , y se le pasara en el onResume esta vista mediante setView , aparte de utilizar mas metodos de la logica, como lo que ocurrira al pulsar el boton, o recoger el usuario actual.

##LoginActivityPresenter

Tendremos toda la logica en el presentador.
Esta clase imprementa la interfaz de presentador, para acceder a los metodos que necesita

Recibe la vista en el momento que se crea la vista
Tiene un constructor que recibe el modelo

El presentador necesita recibir tanto el modelo como la vista

##LoginActivityModel

Implementa la interfaz de modelo
-recibe en el constructor el repositorio

#Repository

##LoginRepository

Interfaz con los metodos necesarios

##MemoryRepository

Implementa la interfaz de LoginRepository

Tiene la clase static LoginModule

#LoginModule


Mediante @provides, hace que las interfaces , reciban como parametro otra interfaz, y devuelva una instancia de la clase (Rellenando el constructor con la dependecia que necesitaban)
-EL presentador el modelo
-El modelo el repositorio

