# 🏛️ Sistema de Administración: Casa de la Cultura

Un sistema integral de escritorio con Interfaz Gráfica de Usuario (GUI) diseñado para agilizar y asegurar los procesos administrativos de un centro cultural. El proyecto se enfoca en la eficiencia operativa, la integridad de los datos y una experiencia de usuario (UX) fluida.

## 🚀 Características Principales

* **Control de Acceso Seguro:** Sistema de Login y gestión de sesiones con confirmación de cierre y salida segura.
* **CRUD Completo de Asistentes:** Registro, consulta, actualización y baja definitiva de usuarios.
* **Gestión Dinámica de Talleres:** * Inscripción a múltiples talleres con prevención de registros duplicados.
  * Cambio de horarios en tiempo real consultando catálogos oficiales.
  * Baja independiente de talleres sin afectar los datos personales del usuario.
* **Cálculo Financiero Automatizado:** Desglose automático de costos (costo base + materiales opcionales) y actualización de totales en vivo.
* **Motor de Búsqueda de Alto Rendimiento:** Filtrado instantáneo por ID o Nombre utilizando carga de datos en memoria (RAM) mediante Listas Ligadas (`LinkedList`).
* **Auditoría Transparente:** Generación automática de una bitácora (`bitacora.dat`) que registra fechas, horas, acciones, detalles y motivos de cada modificación crítica en el sistema.
* **Seguridad e Integridad de Datos:** Validaciones estrictas en formularios mediante Expresiones Regulares (Regex) para evitar la inyección de datos corruptos o mal formateados.

## 🛠️ Arquitectura y Tecnologías

* **Lenguaje:** Java (Paradigma Orientado a Objetos).
* **Interfaz Gráfica:** Java Swing.
* **Persistencia de Datos:** Manejo avanzado de archivos planos (`.dat` / `.csv`) como base de datos nativa, utilizando técnicas de reconstrucción de cadenas (`StringBuilder`) y compensación de lectura de arreglos dinámicos.
* **Estructuras de Datos:** Colecciones de Java (`ArrayList`, `LinkedList`) para la manipulación temporal de la información y optimización de búsquedas.

## 📂 Estructura de Datos (Archivos)
El sistema opera sobre tres archivos principales para garantizar la persistencia:
1. `asistentes.dat`: Almacena la información personal y el "carrito" de talleres de cada usuario.
2. `talleres.dat`: Catálogo maestro de solo lectura con la oferta de clases, horarios y costos.
3. `bitacora.dat`: Registro histórico de auditoría.