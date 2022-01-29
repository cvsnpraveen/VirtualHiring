from django.contrib import admin
from django.contrib.auth.models import User
from .models import order,stock
# Register your models here.

admin.site.register(order)
admin.site.register(stock)

