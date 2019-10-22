package com.example.daggerlogin;

import com.example.daggerlogin.login.LoginActivityMVP;
import com.example.daggerlogin.login.LoginActivityPresenter;
import com.example.daggerlogin.login.model.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PresenterUnitTest {

    LoginActivityPresenter presenter;
    User user;

    LoginActivityMVP.Model mockedModel;
    LoginActivityMVP.View mockedView;


    @Before
    public void initialitation() {
        mockedModel = mock(LoginActivityMVP.Model.class);
        mockedView = mock(LoginActivityMVP.View.class);

        user = new User("Manolo", "Escobar");

        //when(mockedModel.getUser()).thenReturn(user);

        //when(mockedView.getName()).thenReturn("Antonio");
        //when(mockedView.getLastName()).thenReturn("Banderas");

        presenter = new LoginActivityPresenter(mockedModel);
        presenter.setView(mockedView);
    }

    @Test
    public void noExistsInteractionWhitView() {
        presenter.getCurrentUser();

        verify(mockedView, times(1)).showUserNotAvailable();
    }


    @Test
    public void loadUserFromTheRepoWhenValidUserIsPresent() {

        when(mockedModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        //Comprobamos interactuacion con el modelo de datos
        verify(mockedModel, times(1)).getUser();

        //Comprobarmos la interactuacion con la vista
        verify(mockedView, times(1)).setName("Manolo");
        verify(mockedView, times(1)).setLastName("Escobar");
        verify(mockedView, never()).showUserNotAvailable();

    }


    @Test
    public void showErrorMessageWhenUserIsNull() {

        when(mockedModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        //Comprobamos interactuacion con el modelo de datos
        verify(mockedModel, times(1)).getUser();

        //Comprobarmos la interactuacion con la vista
        verify(mockedView, never()).setName("Manolo");
        verify(mockedView, never()).setLastName("Escobar");
        verify(mockedView, times(1)).showUserNotAvailable();

    }


    @Test
    public void createErrorMessageAnyFieldIsEmpty() {

        //Primera prueba poniendo el campo name vacio

        when(mockedView.getName()).thenReturn("");
        presenter.loginButtonClicked();

        verify(mockedView, times(1)).getName();
        verify(mockedView, never()).getLastName();

        verify(mockedView, times(1)).showInputError();

        // Segunda prueba

        when(mockedView.getName()).thenReturn("Antonio");
        when(mockedView.getLastName()).thenReturn("");

        presenter.loginButtonClicked();

        verify(mockedView, times(2)).getName(); // Se llama 2 veces, en la prueba anterior y en esta

        verify(mockedView, times(1)).getLastName(); // antes no paso el test booleano, asi que solo se llama ahora

        verify(mockedView, times(2)).showInputError(); // el metodo se llamo antes y ahora

        ;
    }


    @Test
    public void saveValidUser() {

        when(mockedView.getName()).thenReturn("Dani");
        when(mockedView.getLastName()).thenReturn("Rica");

        presenter.loginButtonClicked();

        //Las llamadas son dobles, una en el if y otra cuando se crea el usuario
        verify(mockedView, times(2)).getName();
        verify(mockedView, times(2)).getLastName();

        //Miramos que el modelo persista en el repo
        verify(mockedModel, times(1)).createUser("Dani", "Rica");

        //Miramos que se muestre el mensaje de exito

        verify(mockedView, times(1)).showUserSaved();


    }
}
