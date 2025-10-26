# Guía de primeros pasos con Git y GitHub (incluye ramas, merge, conflictos y PR)

> Esta guía asume que ya tienes Git instalado y una cuenta activa en GitHub.

## 1) Configuración inicial (una sola vez por equipo)
```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu-correo@ejemplo.com"
git config --global init.defaultBranch main
```

## 2) Crear repo local y primer commit
```bash
mkdir POO-Git-Casos && cd POO-Git-Casos
git init
echo "# POO-Git-Casos" > README.md
mkdir -p caso1 caso2 caso3
git add .
git commit -m "chore: inicializa estructura base"
```

## 3) Conectar con GitHub y publicar
Crea un repositorio vacío en GitHub llamado **POO-Git-Casos** (sin README). Luego:
```bash
git remote add origin https://github.com/<tu-usuario>/POO-Git-Casos.git
git branch -M main
git push -u origin main
```

## 4) Navegación básica
```bash
git status
git log --oneline --decorate --graph --all
```

## 5) Trabajo en ramas
```bash
git checkout -b feature/caso1
# realiza cambios en caso1/UsuarioSimple.java
git add caso1/UsuarioSimple.java
git commit -m "feat(caso1): lectura básica con Scanner"
git push -u origin feature/caso1
```

## 6) Pull Request (PR) en GitHub
1. Abre el repositorio en GitHub.
2. Crea un **Pull Request** desde `feature/caso1` hacia `main`.
3. Asigna revisores (compañeros).
4. Atiende comentarios de revisión de código y realiza nuevos commits si se requieren.
5. Cuando esté aprobado, **Merge** (squash/merge/rebase, según política del equipo).

## 7) Crear conflictos (a propósito) y resolverlos
Para practicar conflictos:
- En `main`, edita la misma línea de `README.md` que también editarás en `feature/conflicto`.

```bash
# rama principal
git checkout main
echo "Línea editada desde main" >> README.md
git commit -am "docs: edición en README desde main"

# rama de conflicto
git checkout -b feature/conflicto
echo "Línea editada desde feature/conflicto" >> README.md
git commit -am "docs: edición en README desde feature/conflicto"
```

Ahora intenta fusionar:
```bash
git checkout main
git merge feature/conflicto
```
Git marcará el **conflicto** en `README.md` con indicadores `<<<<<<<`, `=======`, `>>>>>>>`.
Abre el archivo, elige/combina el contenido correcto, guarda y:
```bash
git add README.md
git commit -m "fix: resuelve conflicto de fusión en README"
```

## 8) Colaboración e invitaciones
- En GitHub, ve a **Settings → Collaborators** y agrega a tus compañeros con permisos de **Write**.
- Ellos pueden **clonar**:
```bash
git clone https://github.com/<tu-usuario>/POO-Git-Casos.git
cd POO-Git-Casos
git checkout -b feature/caso2
# trabajar, commitear, pushear, abrir PR, etc.
```

## 9) Buenas prácticas de commits y PR
- Mensajes tipo *conventional commits*:
  - `feat:`, `fix:`, `docs:`, `chore:`, `refactor:`, `test:`
- PR pequeños, con descripción clara y checklist:
  - [ ] Compila
  - [ ] Pruebas manuales realizadas
  - [ ] Sin *warnings* del compilador
  - [ ] Revisado por N compañeros

## 10) Evidencia de práctica de campo (Acción + Producto)
- **Acción**: ramas creadas, commits, conflictos resueltos, PR abiertos y fusionados.
- **Producto**: código de `caso1`, `caso2`, `caso3`, `guia_git.md`, `informe_final.md` y `README.md` publicados en `main`.
- Adjunta capturas: historial de commits, pantalla de PR con revisiones, lista de *Collaborators*, y *merge* realizado.
