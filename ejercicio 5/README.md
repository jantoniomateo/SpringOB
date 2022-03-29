## Despliegue de apps Spring Boot en Heroku

Crear el archivo 'system.properties' en el proyecto con el siguiente contenido

'''
java.runtime.version=17
'''

1. Crear cuenta en heroku.com y github.com
2. Tener configurado git en el ordenadores (solo hacerlo la primera vez que se instala github)
   1. git config --global user.name "Juan Antonio"
   2. git config --global user.email jantonio.mateo@outlook.com
3. Subir el proyecto desde Intellij IDEA desde la opción Git Share project con github
4. Desde Heroku, crear app y elegir el método Github y buscar el repositorio subido.
5. Habilitar deploy automático y ejecutar Deploy.

## Proveedores 

* Heroku -- Java, Spring, PostgreSQL
* Netfly -- Fronted (React, Angular...)
* Vercel -- Fronted (React, Angular...)