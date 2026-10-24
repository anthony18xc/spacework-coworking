# SpaceWork - Sistema Web de Gestión de Reservas de Espacios Coworking

Proyecto del curso **Integrador I: Sistemas Software** (UTP, 2026).

## Arquitectura
| Capa | Tecnología |
|------|-----------|
| Frontend | ReactJS (Vite) |
| Backend | Java 17 + Spring Boot 3 (API REST) |
| Base de datos | SQL Server |
| Seguridad | JWT (pendiente de implementar) |
| Control de versiones | Git / GitHub |

## Estructura
```
docs/       Documentación (Avance de Proyecto Final 2)
backend/    API REST con Spring Boot
frontend/   Interfaz web con React
```

## Cómo ejecutar
### Backend
```bash
cd backend
# Define la contraseña de SQL Server (usuario sa por defecto)
export DB_PASSWORD=tu_clave
mvn spring-boot:run
```
Requiere una base de datos vacía llamada `spacework`. Endpoint de prueba: `GET http://localhost:8080/api/espacios`

### Frontend
```bash
cd frontend
npm install
npm run dev
```
Abre http://localhost:5173

## Flujo de trabajo con Git
- `main`: versión estable.
- `feature/*`: una rama por funcionalidad, integrada a `main` con merge.
- Commits con prefijos `docs:`, `chore:`, `feat:`, `fix:`.
