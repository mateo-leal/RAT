-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-09-2016 a las 06:26:31
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+05:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

--
-- Base de datos: `db_rat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcargo`
--

CREATE TABLE `tblcargo` (
  `id_cargo` int(4) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `salario` int(15) NOT NULL,
  `estado` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblcargo`
--

INSERT INTO `tblcargo` (`id_cargo`, `cargo`, `salario`, `estado`) VALUES
(1000, 'Presidente', 20000000, 'Activo'),
(1001, 'Analista', 10000000, 'Activo'),
(1002, 'Programador', 6000000, 'Activo'),
(1003, 'Diseñador', 6000000, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblempleado`
--

CREATE TABLE `tblempleado` (
  `id_empleado` int(4) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `fecha_n` date NOT NULL,
  `telefono` int(13) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `id_cargo` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblempleado`
--

INSERT INTO `tblempleado` (`id_empleado`, `nombre`, `apellidos`, `fecha_n`, `telefono`, `direccion`, `email`, `estado`, `id_cargo`) VALUES
(1000, 'Mateo', 'Leal', '1999-12-15', 2937152, 'cra 16b', 'mateolegi@gmail.com', 'Activo', 1000),
(1001, 'Daniel', 'Arboleda', '1999-02-20', 2342341, 'cra 23', 'arboleda.daniel@gmail.com', 'Activo', 1001),
(1002, 'Julián', 'Castaño', '2000-04-12', 2347345, 'cra 65', 'castano.julian@gmail.com', 'Activo', 1002),
(1003, 'Mateo', 'Ortiz', '1998-12-20', 5525443, 'cra 75', 'mateito.ortiz69@gmail.com', 'Activo', 1002);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblentrada_salida`
--

CREATE TABLE `tblentrada_salida` (
  `id_empleado` int(4) NOT NULL,
  `cons` int(4) NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_salida` time NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblentrada_salida`
--

INSERT INTO `tblentrada_salida` (`id_empleado`, `cons`, `hora_entrada`, `hora_salida`, `fecha`) VALUES
(1000, 1000, '07:00:00', '17:00:00', '2005-06-13'),
(1001, 1001, '09:00:00', '22:00:00', '2005-06-14'),
(1002, 1002, '11:00:00', '15:00:00', '2005-02-12'),
(1003, 1003, '07:00:00', '19:00:00', '2005-06-13'),
(1000, 1004, '06:00:00', '20:00:00', '2016-08-01'),
(1000, 1005, '09:30:00', '18:00:00', '2016-08-02'),
(1000, 1006, '05:30:00', '16:00:00', '2016-08-03'),
(1001, 1007, '05:30:00', '12:45:00', '2016-07-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblregistro_actividades`
--

CREATE TABLE `tblregistro_actividades` (
  `id_empleado` int(4) NOT NULL,
  `cons` int(4) NOT NULL,
  `id_actividad` int(4) NOT NULL,
  `usuario_creador` varchar(15) NOT NULL,
  `fecha_actividad` date NOT NULL,
  `estado` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblregistro_actividades`
--

INSERT INTO `tblregistro_actividades` (`id_empleado`, `cons`, `id_actividad`, `usuario_creador`, `fecha_actividad`, `estado`) VALUES
(1000, 1000, 1015, 'Wolcres20', '2016-03-10', 'Activo'),
(1001, 1001, 1256, 'Mateolegi', '2016-05-15', 'Activo'),
(1002, 1002, 1256, 'Ortiz', '2016-04-20', 'Activo'),
(1003, 1003, 1256, 'Estropajo', '2016-04-23', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipo_actividad`
--

CREATE TABLE `tbltipo_actividad` (
  `id_actividad` int(4) NOT NULL,
  `actividad` varchar(30) NOT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `estado` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbltipo_actividad`
--

INSERT INTO `tbltipo_actividad` (`id_actividad`, `actividad`, `descripcion`, `estado`) VALUES
(1015, 'Actividades administrativas', 'Actividades administrativas', 'Activo'),
(1100, 'Página web', 'Página web', 'Inactivo'),
(1256, 'Registro de actividades', 'Registro de actividades', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE `tblusuario` (
  `usuario` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `clave` varchar(128) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `perfil` int(4) NOT NULL,
  `correo` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblusuario`
--

INSERT INTO `tblusuario` (`usuario`, `nombre`, `clave`, `estado`, `perfil`, `correo`) VALUES
('Estropajo', 'Julian Castaño', '123', 'Inactivo', 1001, 'estropajo@gmail.com'),
('Mateolegi', 'Mateo Leal', '1234', 'Activo', 1000, 'mateolegi@gmail.com'),
('Ortiz', 'Mateo Ortiz', '12345', 'Activo', 1001, 'teo@gmail.com'),
('Wolcres20', 'Daniel Arboleda', '123456', 'Activo', 1001, 'wolcres20@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblcargo`
--
ALTER TABLE `tblcargo`
  ADD PRIMARY KEY (`id_cargo`),
  ADD UNIQUE KEY `id_cargo` (`id_cargo`),
  ADD KEY `nombre` (`cargo`);

--
-- Indices de la tabla `tblempleado`
--
ALTER TABLE `tblempleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- Indices de la tabla `tblentrada_salida`
--
ALTER TABLE `tblentrada_salida`
  ADD PRIMARY KEY (`cons`),
  ADD UNIQUE KEY `cons` (`cons`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `tblregistro_actividades`
--
ALTER TABLE `tblregistro_actividades`
  ADD UNIQUE KEY `cons` (`cons`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_actividad` (`id_actividad`),
  ADD KEY `usuario_creador` (`usuario_creador`);

--
-- Indices de la tabla `tbltipo_actividad`
--
ALTER TABLE `tbltipo_actividad`
  ADD PRIMARY KEY (`id_actividad`),
  ADD UNIQUE KEY `id_actividad` (`id_actividad`);

--
-- Indices de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`usuario`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD KEY `perfil` (`perfil`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblempleado`
--
ALTER TABLE `tblempleado`
  ADD CONSTRAINT `tblempleado_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `tblcargo` (`id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblentrada_salida`
--
ALTER TABLE `tblentrada_salida`
  ADD CONSTRAINT `tblentrada_salida_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tblempleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblregistro_actividades`
--
ALTER TABLE `tblregistro_actividades`
  ADD CONSTRAINT `tblregistro_actividades_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `tblempleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tblregistro_actividades_ibfk_2` FOREIGN KEY (`usuario_creador`) REFERENCES `tblusuario` (`usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tblregistro_actividades_ibfk_3` FOREIGN KEY (`id_actividad`) REFERENCES `tbltipo_actividad` (`id_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD CONSTRAINT `tblusuario_ibfk_1` FOREIGN KEY (`perfil`) REFERENCES `tblcargo` (`id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
