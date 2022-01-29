from django.urls import path
from . import views
urlpatterns = [
    path("",views.home,name="home"),
    path("neworder",views.neworder,name="neworder"),
    path("adminpage",views.adminpage,name="adminpage"),
    path("adminupdate",views.adminupdate,name="adminupdate"),
]