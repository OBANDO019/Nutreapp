import { useMemo, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { ROLES, DEPARTAMENTOS } from "../models/enums.js";
import { registrarUsuario, abrirSesion } from "../services/usuarios.js";

const vacio = {
  nombre: "",
  correo: "",
  rol: "",
  departamento: "",
  contrasenia: "",
  confirmar: "",
};

function validar(f) {
  const e = {};
  if (f.nombre.trim().length < 3) e.nombre = "Escribe tu nombre completo.";
  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(f.correo)) e.correo = "Escribe un correo válido.";
  if (!f.rol) e.rol = "Selecciona un rol.";
  if (!f.departamento) e.departamento = "Selecciona un departamento.";
  if (f.contrasenia.length < 8) e.contrasenia = "Usa al menos 8 caracteres.";
  if (f.confirmar !== f.contrasenia) e.confirmar = "Las contraseñas no coinciden.";
  return e;
}

function Campo({ label, error, children }) {
  return (
    <label className="campo">
      <span>{label}</span>
      {children}
      {error && <small className="error">{error}</small>}
    </label>
  );
}

export default function Registro() {
  const navigate = useNavigate();
  // UUID generado en el cliente; si tu backend lo genera, quita este campo.
  const id = useMemo(() => crypto.randomUUID(), []);
  const [form, setForm] = useState(vacio);
  const [errores, setErrores] = useState({});
  const [errorGeneral, setErrorGeneral] = useState("");

  const cambiar = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const enviar = (e) => {
    e.preventDefault();
    // Se leen los valores del DOM: el autocompletado del navegador
    // (p. ej. contraseñas sugeridas) no siempre dispara onChange.
    const actuales = Object.fromEntries(new FormData(e.currentTarget));
    const valores = { ...form, ...actuales };
    setForm(valores);

    const errs = validar(valores);
    setErrores(errs);
    if (Object.keys(errs).length) return;

    try {
      const { confirmar, ...datos } = valores;
      const usuario = registrarUsuario({ id, ...datos });
      abrirSesion(usuario.id);
      navigate("/home");
    } catch (err) {
      setErrorGeneral(err.message);
    }
  };

  return (
    <main className="pagina">
      <section className="marca" aria-hidden="true">
        <img src="/logo-nutresa.png" alt="" />
      </section>

      <section className="panel">
        <h1>Crea tu cuenta</h1>
        <p className="subtitulo">Completa tus datos para registrarte.</p>

        <form onSubmit={enviar} noValidate>
          <label className="campo">
            <span>Identificador</span>
            <input type="text" value={id} readOnly className="solo-lectura" />
          </label>

          <Campo error={errores.nombre} label="Nombre">
            <input
              type="text"
              name="nombre"
              autoComplete="name"
              value={form.nombre}
              onChange={cambiar}
            />
          </Campo>

          <Campo error={errores.correo} label="Correo">
            <input
              type="email"
              name="correo"
              autoComplete="email"
              value={form.correo}
              onChange={cambiar}
            />
          </Campo>

          <div className="fila">
            <Campo error={errores.rol} label="Rol">
              <select name="rol" value={form.rol} onChange={cambiar}>
                <option value="">Selecciona…</option>
                {ROLES.map((r) => (
                  <option key={r.value} value={r.value}>
                    {r.label}
                  </option>
                ))}
              </select>
            </Campo>

            <Campo error={errores.departamento} label="Departamento">
              <select name="departamento" value={form.departamento} onChange={cambiar}>
                <option value="">Selecciona…</option>
                {DEPARTAMENTOS.map((d) => (
                  <option key={d.value} value={d.value}>
                    {d.label}
                  </option>
                ))}
              </select>
            </Campo>
          </div>

          <div className="fila">
            <Campo error={errores.contrasenia} label="Contraseña">
              <input
                type="password"
                name="contrasenia"
                autoComplete="new-password"
                value={form.contrasenia}
                onChange={cambiar}
              />
            </Campo>

            <Campo error={errores.confirmar} label="Confirmar contraseña">
              <input
                type="password"
                name="confirmar"
                autoComplete="new-password"
                value={form.confirmar}
                onChange={cambiar}
              />
            </Campo>
          </div>

          {errorGeneral && (
            <p className="error" role="alert">
              {errorGeneral}
            </p>
          )}

          <button type="submit" className="boton">
            Crear cuenta
          </button>
        </form>

        <p className="pie">
          ¿Ya tienes cuenta? <Link to="/">Ingresar</Link>
        </p>
      </section>
    </main>
  );
}
