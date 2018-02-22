package u6_12_06_hotel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JOptionPane;

public class U6_12_06_Hotel {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int f, h, correcto, marte, opcion, estancia = 0, decea, sencilla = 10, doble = 10, triple = 10, suite = 5, suitePresidencial = 2, cont = 0;
        String telSal = null, RFC1 = null, habitacionBaja = null, a = null, b = null, c = null, d, z, g, x = null, nombre = null, tipoHabitacion = null, correo = null, RFC = null, dominio = null, numTelefono = null, salida = null;
        float pago = 0.0f, pagoAntes = 0.0f, j, total = 0;
        double gastosExtras = 0.0, pago1 = 500, pago2 = 600, pago3 = 700, pago4 = 850, pago5 = 1000, p, o, q, u, y;
        char valor = 0;
        boolean vacio, rfc1 = false, rfc2 = false, arroba = false, espacio = false, numero = false, corazon = false, bandera = false, seguir = false;

        Calendar c1 = GregorianCalendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
        c1.add(Calendar.DAY_OF_YEAR, estancia);

        String nomArchivo = ("C:\\Users\\Usuario\\Dropbox\\Trabajos\\Tecnológico\\Segundo Semestre\\Programación\\Unidad 6\\U6_12_06_Hotel\\registro.txt");
        String bajasArchivo = ("C:\\Users\\Usuario\\Dropbox\\Trabajos\\Tecnológico\\Segundo Semestre\\Programación\\Unidad 6\\U6_12_06_Hotel\\Bajas.txt");
        String precios = ("C:\\Users\\Usuario\\Dropbox\\Trabajos\\Tecnológico\\Segundo Semestre\\Programación\\Unidad 6\\U6_12_06_Hotel\\PRECIOS.txt");
        String nomArchivos=("C:\\Users\\Usuario\\Dropbox\\Trabajos\\Tecnológico\\Segundo Semestre\\Programación\\Unidad 6\\U6_12_06_Hotel\\Orale.txt");
        FileInputStream fis, fi, fisi,fiss; //objeto para guardar el nombre del archivo a leer
        DataInputStream dis, di, disi,diss; //objeto para guardar los datos del archivo a leer

        FileOutputStream fos, fo, fosi,foss; //objeto para guardar el nombre del archivo a crear
        DataOutputStream dos, ds, dosi,doss;//objeto para guardar los datos del archivo a crear       

        fo = new FileOutputStream(bajasArchivo, true);
        ds = new DataOutputStream(fo);

        fos = new FileOutputStream(nomArchivo, true);
        dos = new DataOutputStream(fos);
        
        foss = new FileOutputStream(nomArchivos, true);
        doss= new DataOutputStream(foss);
        
        fosi = new FileOutputStream(precios, true);
        dosi = new DataOutputStream(fosi);

        Random aleatorio = new Random();

        fis = new FileInputStream(nomArchivo);
        dis = new DataInputStream(fis);
        while (dis.available() != 0) {
            a = dis.readUTF();
            b = dis.readUTF();
            c = dis.readUTF();
            d = dis.readUTF();
            z = dis.readUTF();
            f = dis.readInt();
            g = dis.readUTF();
            h = dis.readInt();
            x = dis.readUTF();
            j = dis.readFloat();

            if (z.equalsIgnoreCase("sencilla")) {
                sencilla--;
            } else {
                if (z.equalsIgnoreCase("doble")) {
                    doble--;
                } else {
                    if (z.equalsIgnoreCase("triple")) {
                        triple--;
                    } else {
                        if (z.equalsIgnoreCase("suite")) {
                            suite--;
                        } else {
                            suitePresidencial--;
                        }
                    }
                }
            }
        }

        fis.close();
        dis.close();

        fi = new FileInputStream(bajasArchivo);
        di = new DataInputStream(fi);
        while (di.available() != 0) {

            a = di.readUTF();
            b = di.readUTF();
            c = di.readUTF();

            if (a.equalsIgnoreCase("sencilla")) {
                sencilla++;
            } else {
                if (a.equalsIgnoreCase("doble")) {
                    doble++;
                } else {
                    if (a.equalsIgnoreCase("triple")) {
                        triple++;
                    } else {
                        if (a.equalsIgnoreCase("suite")) {
                            suite++;
                        } else {
                            suitePresidencial++;
                        }
                    }
                }
            }
        }

        fi.close();
        di.close();

        fisi = new FileInputStream(precios);
        disi = new DataInputStream(fisi);

        while (disi.available() != 0) {

            q = disi.readDouble();
            p = disi.readDouble();
            o = disi.readDouble();
            u = disi.readDouble();
            y = disi.readDouble();
            pago1 = q;
            pago2 = p;
            pago3 = o;
            pago4 = u;
            pago5 = y;
        }

        fisi.close();
        disi.close();

        do {

            opcion = JOptionPane.showOptionDialog(null, "SELECCIONE OPCIÓN", "Menú Principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ALTAS", "BAJAS", "MODIFICAR", "MOSTRAR", "SALIR"}, null);
            
            correcto = aleatorio.nextInt(1000000000);

            switch (opcion) {
                case 0:
                    if (sencilla == 0 && doble == 0 && triple == 0 && suite == 0 && suitePresidencial == 0) {
                        JOptionPane.showMessageDialog(null, "NO SE ENCUENTRAN HABITACIONES DISPONIBLES EN ESE MOMENTO", "NOTIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {

                        do {
                            vacio = false;
                            corazon = false;

                            nombre = JOptionPane.showInputDialog(null, "Nombre del que va a rentar:", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE);

                            for (int i = 0; i < nombre.length(); i++) {
                                valor = nombre.charAt(i);
                                if (valor == ' ') {
                                    vacio = true;
                                    corazon = false;
                                } else {
                                    if (Character.isLetter(valor)) {
                                        corazon = false;
                                        vacio = false;
                                    } else {
                                        corazon = true;
                                        vacio = false;
                                        break;
                                    }
                                }
                            }

                            if (vacio) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su nombre de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                            if (corazon) {
                                JOptionPane.showMessageDialog(null, "Tu ingresaste algún elemento que no es una letra,\n Le pedimos de favor que vuelva a ingresar su nombre de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                            if (nombre.equals("")) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su nombre de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                vacio = true;
                            }

                        } while (vacio || corazon);

                        decea = JOptionPane.showOptionDialog(null, "¿DESEA FACTURA?", "FACTURAR", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, null);

                        if (decea == 0) {

                            do {
                                JOptionPane.showMessageDialog(null, "Datos del RFC\n Primeros 4 datos son LETRAS. \n Siguientes 6 dígitos son NÚMEROS\n Los últimos 3 dígitos es su HOMOCLAVE", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                                RFC = JOptionPane.showInputDialog(null, "RFC del que va a rentar el cuarto:", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE);
                                RFC = RFC.toUpperCase();

                                for (int i = 0; i < RFC.length(); i++) {
                                    valor = RFC.charAt(i);
                                    if (valor == ' ') {
                                        vacio = true;
                                    } else {
                                        vacio = false;
                                    }
                                }

                                if (vacio == false) {

                                    if (RFC.length() == 13) {
                                        rfc1 = false;
                                        for (int i = 0; i < 4; i++) {
                                            valor = RFC.charAt(i);
                                            //comparacion = Character.toString(valor);
                                            if (Character.isLetter(valor)) {
                                                rfc1 = false;
                                            } else {
                                                rfc1 = true;
                                                break;
                                            }
                                        }
                                        if (!rfc1) {
                                            rfc2 = false;
                                            for (int i = 4; i < 10; i++) {
                                                valor = RFC.charAt(i);

                                                if (Character.isDigit(valor)) {
                                                    rfc2 = false;
                                                } else {
                                                    rfc2 = true;
                                                    break;
                                                }
                                            }
                                        }

                                        if (rfc1) {
                                            JOptionPane.showMessageDialog(null, "Usted ingreso dentro de los primeros cuatro espacios un NÚMERO,\n en éstos espacios deben ir solamente LETRAS\n Le pedimos de favor, vuelva a ingresar su RFC\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }
                                        if (rfc2) {
                                            JOptionPane.showMessageDialog(null, "Usted ingreso entre los espacios 4 y 9 un valor que no es un NÚMERO,\n en éstos espacios deben ir solamente NÚMEROS\n Le pedimos de favor, vuelva a ingresar su RFC\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Los dígitos del RFC están Incompletos, DEBEN SER 13 DÍGITOS\n Le pedimos de favor que vuelva a ingresar el RFC\n¡¡ LAMENTAMOS LAS MOLESTIAS !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        vacio = true;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Dejaste el espacio vacio\n Favor de ingresar un dato correcto\n ¡¡ Lamentamos las molestias!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    vacio = true;
                                }

                            } while (vacio || rfc1 || rfc2);

                            fis = new FileInputStream(nomArchivo);
                            dis = new DataInputStream(fis);

                            bandera = false;

                            while (dis.available() != 0) {
                                a = dis.readUTF();
                                b = dis.readUTF();
                                c = dis.readUTF();
                                d = dis.readUTF();
                                z = dis.readUTF();
                                f = dis.readInt();
                                g = dis.readUTF();
                                h = dis.readInt();
                                x = dis.readUTF();
                                j = dis.readFloat();

                                if (b.equalsIgnoreCase(RFC)) {
                                    bandera = true;
                                    break;
                                }
                            }

                            fis.close();
                            dis.close();

                            if (bandera) {
                                JOptionPane.showMessageDialog(null, "Ese RFC ya existe,\n Usted no puede seguir ingresando datos\n ¡¡ Lamentamos las molestias !!\n OPERACIÓN CANCELADA", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }

                            do {
                                dominio = (String) JOptionPane.showInputDialog(null, "¿En cuál dominio tiene su correo?", "DOMINIO CORREO", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"@live.com.mx", "@hotmail.com", "@outlook.com", "@gmail.com", "@yahoo.com", "@itcolima.edu.mx", "@ucol.mx"}, null);

                                correo = JOptionPane.showInputDialog(null, "Escriba SOLAMENTE el usuario del correo:", "USUARIO DEL CORREO", JOptionPane.QUESTION_MESSAGE);
                                arroba = false;
                                espacio = false;
                                vacio = false;

                                for (int i = 0; i < correo.length(); i++) {
                                    valor = correo.charAt(i);
                                    if (valor == '@') {
                                        arroba = true;
                                        break;
                                    }
                                    if (valor == ' ') {
                                        espacio = true;
                                        break;
                                    }
                                }

                                if (arroba) {
                                    JOptionPane.showMessageDialog(null, "Usted ingreso UN ARROBA @ en el nombre del usuario,\n eso no es permitido,\n Le pedimos de favor que vuelva a ingresar los datos de su correo", "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                                if (espacio) {
                                    JOptionPane.showMessageDialog(null, "Usted ingreso UN ESPACIO EN BLANCO en el nombre del usuario,\n eso no es permitido,\n Le pedimos de favor que vuelva a ingresar los datos de su correo", "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                                if (correo.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su USUARIO de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    vacio = true;
                                }
                            } while (arroba || espacio || vacio);

                            fis = new FileInputStream(nomArchivo);
                            dis = new DataInputStream(fis);

                            bandera = false;

                            while (dis.available() != 0) {
                                a = dis.readUTF();
                                b = dis.readUTF();
                                c = dis.readUTF();
                                d = dis.readUTF();
                                z = dis.readUTF();
                                f = dis.readInt();
                                g = dis.readUTF();
                                h = dis.readInt();
                                x = dis.readUTF();
                                j = dis.readFloat();

                                if (c.equalsIgnoreCase(correo + dominio)) {
                                    bandera = true;
                                    break;
                                }
                            }

                            fis.close();
                            dis.close();

                            if (bandera) {
                                JOptionPane.showMessageDialog(null, "Ese Correo ya existe,\n Usted no puede seguir ingresando datos\n ¡¡ Lamentamos las molestias !!\n OPERACIÓN CANCELADA", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }

                        do {
                            vacio = false;
                            numero = false;

                            numTelefono = JOptionPane.showInputDialog(null, "Número del teléfono del que se va a hospedar:", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE);

                            for (int i = 0; i < numTelefono.length(); i++) {
                                valor = numTelefono.charAt(i);
                                if (valor == ' ') {
                                    vacio = true;
                                    numero = false;
                                } else {
                                    if (!Character.isDigit(valor)) {
                                        numero = true;
                                        vacio = false;
                                        break;
                                    } else {
                                        vacio = false;
                                        numero = false;
                                    }
                                }
                            }

                            if (vacio) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su Número de teléfono de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                            if (numero) {
                                JOptionPane.showMessageDialog(null, "Tu ingresaste un dato que no es un número,\n Le pedimos de favor que vuelva a ingresar su Número de teléfono de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                            if (numTelefono.equals("")) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su Número de teléfono de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                vacio = true;
                            }

                        } while (vacio || numero);

                        fis = new FileInputStream(nomArchivo);
                        dis = new DataInputStream(fis);

                        bandera = false;

                        while (dis.available() != 0) {
                            a = dis.readUTF();
                            b = dis.readUTF();
                            c = dis.readUTF();
                            d = dis.readUTF();
                            z = dis.readUTF();
                            f = dis.readInt();
                            g = dis.readUTF();
                            h = dis.readInt();
                            x = dis.readUTF();
                            j = dis.readFloat();

                            if (d.equalsIgnoreCase(numTelefono)) {
                                bandera = true;
                                break;
                            }
                        }

                        fis.close();
                        dis.close();

                        if (bandera) {
                            JOptionPane.showMessageDialog(null, "Ese Número Telefónico ya existe,\n Usted no puede seguir ingresando datos\n ¡¡ Lamentamos las molestias !!\n OPERACIÓN CANCELADA", "ERROR", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        JOptionPane.showMessageDialog(null, "Fecha y Hora a la que ingresa:\n" + c1.getTime().toLocaleString(), "TIEMPO DE INGRESO", JOptionPane.INFORMATION_MESSAGE);

                        do {
                            vacio = false;

                            try {
                                do {
                                    estancia = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos días va a hospedarse?", "INGRESO DE INFORMCACIÓN", JOptionPane.QUESTION_MESSAGE));

                                    if (estancia == 0) {
                                        JOptionPane.showMessageDialog(null, "No se puede dejar la estancia en el hotel como CERO,\n Le pedimos de favor que vuelva a ingresar su Estancia en el Hotel MARAVILLAS de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        if (estancia < 0) {
                                            JOptionPane.showMessageDialog(null, "No se puede ingresar un dato en la estancia MENOR A CERO,\n Le pedimos de favor que vuelva a ingresar su Estancia en el Hotel MARAVILLAS de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }

                                } while (estancia == 0 || estancia < 0);

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                vacio = true;
                            }
                        } while (vacio);

                        JOptionPane.showMessageDialog(null, "Fecha y hora de salida:\n" + sdf.format(c1.getTime()), "TIEMPO DE SALIDA", JOptionPane.INFORMATION_MESSAGE);

                        JOptionPane.showMessageDialog(null, "LAS HABITACIONES DESOCUPADAS EN ÉSTE MOMENTO SON\n Sencilla: " + sencilla + " habitacion(es)\n Doble: " + doble + " habitacion(es)\n Triple: " + triple + " habitacion(es)\n Suite: " + suite + " habitacion(es)\n Suite Presidencial: " + suitePresidencial + " habitacion(es)");

                        do {
                            corazon = false;

                            tipoHabitacion = (String) JOptionPane.showInputDialog(null, "¿En qué habitación se desea hospedar?", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SENCILLA", "DOBLE", "TRIPLE", "SUITE", "SUITE PRESIDENCIAL"}, "SELECCIONE OPCIÓN");

                            if (tipoHabitacion.equals("SENCILLA")) {
                                if (sencilla == 0) {
                                    JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de ese tipo\n Lametamos los incovenientes presentados\n Le pedimos de favor volver a ingresar una habitación", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    corazon = true;
                                } else {
                                    pagoAntes = (float) (estancia * pago1);
                                    pago = (float) ((pagoAntes * 0.16) + pagoAntes);
                                }
                            } else {
                                if (tipoHabitacion.equals("DOBLE")) {
                                    if (doble == 0) {
                                        corazon = true;
                                        JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de ese tipo\n Lametamos los incovenientes presentados\n Le pedimos de favor volver a ingresar una habitación", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        pagoAntes = (float) (estancia * pago2);
                                        pago = (float) ((pagoAntes * 0.16) + pagoAntes);
                                    }
                                } else {
                                    if (tipoHabitacion.equals("TRIPLE")) {
                                        if (triple == 0) {
                                            corazon = true;
                                            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de ese tipo\n Lametamos los incovenientes presentados\n Le pedimos de favor volver a ingresar una habitación", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            pagoAntes = (float) (estancia * pago3);
                                            pago = (float) ((pagoAntes * 0.16) + pagoAntes);
                                        }

                                    } else {
                                        if (tipoHabitacion.equals("SUITE")) {
                                            if (suite == 0) {
                                                corazon = true;
                                                JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de ese tipo\n Lametamos los incovenientes presentados\n Le pedimos de favor volver a ingresar una habitación", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                pagoAntes = (float) (estancia * pago4);
                                                pago = (float) ((pagoAntes * 0.16) + pagoAntes);
                                            }

                                        } else {
                                            if (suitePresidencial == 0) {
                                                corazon = true;
                                                JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de ese tipo\n Lametamos los incovenientes presentados\n Le pedimos de favor volver a ingresar una habitación", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                pagoAntes = (float) (estancia * pago5);
                                                pago = (float) ((pagoAntes * 0.16) + pagoAntes);
                                            }
                                        }
                                    }
                                }
                            }
                        } while (corazon);

                        if (decea == 0) {
                            JOptionPane.showMessageDialog(null, "   HOTEL MARAVILLAS\n  Le da la más coordial bienvenida a:\n Nombre: " + nombre + "\n RFC: " + RFC + "\n Correo: " + correo + dominio + "\n Número de telfóno: " + numTelefono + "\n Tipo de habitación: " + tipoHabitacion + "\n Se va a hospedar en el cuarto Número: " + correcto + "\n Fecha y hora de entrada: " + c1.getTime().toLocaleString() + "\n Días de estancia: " + estancia + " día(s)\n Fecha de Salida: " + sdf.format(c1.getTime()) + "\n Total a pagar: $ " + pago + " pesos");
                            marte = JOptionPane.showOptionDialog(null, "¿Los datos son correctos?", "VERIFICACIÓN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, null);
                            if (marte == 0) {
                                dos.writeUTF(nombre);
                                dos.writeUTF(RFC);
                                dos.writeUTF(correo + dominio);
                                dos.writeUTF(numTelefono);
                                dos.writeUTF(tipoHabitacion);
                                dos.writeInt(correcto);
                                dos.writeUTF(c1.getTime().toLocaleString());
                                dos.writeInt(estancia);
                                dos.writeUTF(sdf.format(c1.getTime()));
                                dos.writeFloat(pago);

                                if (tipoHabitacion.equals("SENCILLA")) {
                                    if (sencilla == 0) {

                                    } else {
                                        sencilla--;
                                    }
                                } else {
                                    if (tipoHabitacion.equals("DOBLE")) {
                                        if (doble == 0) {

                                        } else {
                                            doble--;
                                        }
                                    } else {
                                        if (tipoHabitacion.equals("TRIPLE")) {
                                            if (triple == 0) {

                                            } else {
                                                triple--;
                                            }

                                        } else {
                                            if (tipoHabitacion.equals("SUITE")) {
                                                if (suite == 0) {

                                                } else {
                                                    suite--;
                                                }

                                            } else {
                                                if (suitePresidencial == 0) {
                                                } else {
                                                    suitePresidencial--;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "   HOTEL MARAVILLAS\n  Le da la más coordial bienvenida a:\n Nombre del que renta: " + nombre + "\n Número de telfóno: " + numTelefono + "\n Tipo de habitación: " + tipoHabitacion + "\n Se va a hospedar en el cuarto Número: " + correcto + "\n\n Fecha y hora de entrada: " + c1.getTime().toLocaleString() + "\n Días de estancia: " + estancia + " día(s)\n Fecha de Salida: " + sdf.format(c1.getTime()) + "\n Total a pagar: $ " + pago + " pesos");
                            marte = JOptionPane.showOptionDialog(null, "¿Los datos son correctos?", "VERIFICACIÓN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, null);
                            if (marte == 0) {
                                dos.writeUTF(nombre);
                                dos.writeUTF("-------------");
                                dos.writeUTF("-------------");
                                dos.writeUTF(numTelefono);
                                dos.writeUTF(tipoHabitacion);
                                dos.writeInt(correcto);
                                dos.writeUTF(c1.getTime().toLocaleString());
                                dos.writeInt(estancia);
                                dos.writeUTF(sdf.format(c1.getTime()));
                                dos.writeFloat(pago);

                                if (tipoHabitacion.equals("SENCILLA")) {
                                    if (sencilla == 0) {

                                    } else {
                                        sencilla--;
                                    }
                                } else {
                                    if (tipoHabitacion.equals("DOBLE")) {
                                        if (doble == 0) {

                                        } else {
                                            doble--;
                                        }
                                    } else {
                                        if (tipoHabitacion.equals("TRIPLE")) {
                                            if (triple == 0) {

                                            } else {
                                                triple--;
                                            }

                                        } else {
                                            if (tipoHabitacion.equals("SUITE")) {
                                                if (suite == 0) {

                                                } else {
                                                    suite--;
                                                }

                                            } else {
                                                if (suitePresidencial == 0) {
                                                } else {
                                                    suitePresidencial--;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 1:

                    fis = new FileInputStream(nomArchivo);
                    dis = new DataInputStream(fis);

                    if (dis.available() == 0) {
                        JOptionPane.showMessageDialog(null, "No se han registrado datos en el archivo\n Lamentamos las molestias", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        do {
                            vacio = false;
                            numero = false;

                            telSal = JOptionPane.showInputDialog(null, "Número del teléfono del que se va retirar:", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE);

                            for (int i = 0; i < telSal.length(); i++) {
                                valor = telSal.charAt(i);
                                if (valor == ' ') {
                                    vacio = true;
                                    numero = false;
                                } else {
                                    if (!Character.isDigit(valor)) {
                                        numero = true;
                                        vacio = false;
                                        break;
                                    } else {
                                        vacio = false;
                                        numero = false;
                                    }
                                }
                            }

                            if (vacio) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su Número de teléfono de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                            if (numero) {
                                JOptionPane.showMessageDialog(null, "Tu ingresaste un dato que no es un número,\n Le pedimos de favor que vuelva a ingresar su Número de teléfono de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                            if (telSal.equals("")) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su Número de teléfono de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                vacio = true;
                            }

                        } while (vacio || numero);

                        fis = new FileInputStream(nomArchivo);
                        dis = new DataInputStream(fis);

                        bandera = false;

                        while (dis.available() != 0) {
                            a = dis.readUTF();
                            b = dis.readUTF();
                            c = dis.readUTF();
                            d = dis.readUTF();
                            z = dis.readUTF();
                            f = dis.readInt();
                            g = dis.readUTF();
                            h = dis.readInt();
                            x = dis.readUTF();
                            j = dis.readFloat();

                            if (d.equalsIgnoreCase(telSal)) {
                                bandera = true;
                                break;
                            }
                        }

                        fis.close();
                        dis.close();

                        if (bandera == false) {
                            JOptionPane.showMessageDialog(null, "Ese Número Telefónico NO existe,\n Usted no puede seguir ingresando datos\n ¡¡ Lamentamos las molestias !!\n OPERACIÓN CANCELADA", "ERROR", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else {

                            fis = new FileInputStream(nomArchivo);
                            dis = new DataInputStream(fis);

                            if (dis.available() == 0) {
                                JOptionPane.showMessageDialog(null, "No se han registrado datos en el archivo\n Lamentamos las molestias", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else {
                                fis = new FileInputStream(nomArchivo);
                                dis = new DataInputStream(fis);

                                fiss = new FileInputStream(nomArchivos);
                                diss = new DataInputStream(fiss);

                                while (dis.available() != 0) {
                                    a = dis.readUTF();
                                    b = dis.readUTF();
                                    c = dis.readUTF();
                                    d = dis.readUTF();
                                    z = dis.readUTF();
                                    f = dis.readInt();
                                    g = dis.readUTF();
                                    h = dis.readInt();
                                    x = dis.readUTF();
                                    j = dis.readFloat();

                                    if (!d.equalsIgnoreCase(telSal)) {
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeInt(dis.readInt());
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeInt(dis.readInt());
                                        doss.writeUTF(dis.readUTF());
                                        doss.writeFloat(dis.readFloat());
                                    }
                                }

                                nomArchivo = nomArchivos;
                                
                                fis.close();
                                dis.close();
                                
                                fiss.close();
                                diss.close();
                                fos.close();
                                dos.close();
                                foss.close();
                                doss.close();
                                
                                //nomArchivo = "C:\\Users\\Usuario\\Dropbox\\Trabajos\\Tecnológico\\Segundo Semestre\\Programación\\Unidad 6\\U6_12_06_Hotel\\registro.txt";

                            }
                        }
                        /*do {
                            vacio = false;
                            corazon = false;

                            salida = JOptionPane.showInputDialog(null, "Ingrese el Nombre del Huesped que se retira:", "SALIDA", JOptionPane.INFORMATION_MESSAGE);

                            for (int i = 0; i < salida.length(); i++) {
                                valor = salida.charAt(i);
                                if (valor == ' ') {
                                    vacio = true;
                                    corazon = false;
                                } else {
                                    if (Character.isLetter(valor)) {
                                        corazon = false;
                                        vacio = false;
                                    } else {
                                        corazon = true;
                                        vacio = false;
                                        break;
                                    }
                                }
                            }

                            if (vacio) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su nombre de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                            if (corazon) {
                                JOptionPane.showMessageDialog(null, "Tu ingresaste algún elemento que no es una letra,\n Le pedimos de favor que vuelva a ingresar su nombre de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                            if (salida.equals("")) {
                                JOptionPane.showMessageDialog(null, "Tu dejaste el espacio vacio,\n Le pedimos de favor que vuelva a ingresar su nombre de forma CORRECTA\n ¡¡ Lamentamos las molestias causadas !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                vacio = true;
                            }

                        } while (vacio || corazon);

                        fis = new FileInputStream(nomArchivo);
                        dis = new DataInputStream(fis);
                        fiss = new FileInputStream(nomArchivos);
                        diss = new DataInputStream(fiss);
                        seguir = true;

                        while (dis.available() != 0) {
                            a = dis.readUTF();
                            b = dis.readUTF();
                            c = dis.readUTF();
                            d = dis.readUTF();
                            z = dis.readUTF();
                            f = dis.readInt();
                            g = dis.readUTF();
                            h = dis.readInt();
                            x = dis.readUTF();
                            j = dis.readFloat();

                            if (a.equalsIgnoreCase(salida)) {
                             
                                bandera = true;
                                total = j;
                                habitacionBaja = z;
                                if (b.equalsIgnoreCase("-------------")) {
                                    seguir = false;
                            
                                }
                                break;
                            }
                        }

                        fis.close();
                        dis.close();

                        if (bandera == false) {
                            JOptionPane.showMessageDialog(null, "No Hay ningun registro en el HOTEL MARAVILLAS, con ese NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else {

                            if (seguir) {
                                
                                do {
                                    JOptionPane.showMessageDialog(null, "Datos del RFC\n Primeros 4 datos son LETRAS. \n Siguientes 6 dígitos son NÚMEROS\n Los últimos 3 dígitos es su HOMOCLAVE", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                                    RFC1 = JOptionPane.showInputDialog(null, "Ingrese el RFC de la persona que va a retirarse del hotel:", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE);
                                    RFC1 = RFC1.toUpperCase();

                                    for (int i = 0; i < RFC1.length(); i++) {
                                        valor = RFC1.charAt(i);
                                        if (valor == ' ') {
                                            vacio = true;
                                        } else {
                                            vacio = false;
                                        }
                                    }

                                    if (vacio == false) {

                                        if (RFC1.length() == 13) {
                                            rfc1 = false;
                                            for (int i = 0; i < 4; i++) {
                                                valor = RFC1.charAt(i);
                                                //comparacion = Character.toString(valor);
                                                if (Character.isLetter(valor)) {
                                                    rfc1 = false;
                                                } else {
                                                    rfc1 = true;
                                                    break;
                                                }
                                            }
                                            if (!rfc1) {
                                                rfc2 = false;
                                                for (int i = 4; i < 10; i++) {
                                                    valor = RFC1.charAt(i);

                                                    if (Character.isDigit(valor)) {
                                                        rfc2 = false;
                                                    } else {
                                                        rfc2 = true;
                                                        break;
                                                    }
                                                }
                                            }

                                            if (rfc1) {
                                                JOptionPane.showMessageDialog(null, "Usted ingreso dentro de los primeros cuatro espacios un NÚMERO,\n en éstos espacios deben ir solamente LETRAS\n Le pedimos de favor, vuelva a ingresar su RFC\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                            if (rfc2) {
                                                JOptionPane.showMessageDialog(null, "Usted ingreso entre los espacios 4 y 9 un valor que no es un NÚMERO,\n en éstos espacios deben ir solamente NÚMEROS\n Le pedimos de favor, vuelva a ingresar su RFC\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Los dígitos del RFC están Incompletos, DEBEN SER 13 DÍGITOS\n Le pedimos de favor que vuelva a ingresar el RFC\n¡¡ LAMENTAMOS LAS MOLESTIAS !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            vacio = true;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Dejaste el espacio vacio\n Favor de ingresar un dato correcto\n ¡¡ Lamentamos las molestias!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        vacio = true;
                                    }
                                } while (vacio || rfc1 || rfc2);

                                bandera = false;

                                fis = new FileInputStream(nomArchivo);
                                dis = new DataInputStream(fis);

                                while (dis.available() != 0) {
                                    a = dis.readUTF();
                                    b = dis.readUTF();
                                    c = dis.readUTF();
                                    d = dis.readUTF();
                                    z = dis.readUTF();
                                    f = dis.readInt();
                                    g = dis.readUTF();
                                    h = dis.readInt();
                                    x = dis.readUTF();
                                    j = dis.readFloat();

                                    if (b.equalsIgnoreCase(RFC1)) {
                                        bandera = true;
                                        habitacionBaja = z;
                                        total = j;
                                        salida = a;
                                        break;
                                    }
                                }

                                fis.close();
                                dis.close();
                            } else {
                                RFC1 = "-------------";
                                
                                fis = new FileInputStream(nomArchivo);
                                dis = new DataInputStream(fis);

                                while (dis.available() != 0) {
                                    a = dis.readUTF();
                                    b = dis.readUTF();
                                    c = dis.readUTF();
                                    d = dis.readUTF();
                                    z = dis.readUTF();
                                    f = dis.readInt();
                                    g = dis.readUTF();
                                    h = dis.readInt();
                                    x = dis.readUTF();
                                    j = dis.readFloat();

                                    if (a.equalsIgnoreCase(salida)) {
                                        habitacionBaja = z;                                        
                                        break;
                                    }
                                }

                                fis.close();
                                dis.close();
                            }

                            if (bandera == false) {
                                JOptionPane.showMessageDialog(null, "No Hay ningun registro en el HOTEL MARAVILLAS, con ese RFC", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else {

                                tipoHabitacion = (String) JOptionPane.showInputDialog(null, "¿En qué habitación se hospedo el que va a salir?", "INGRESO DE DATOS", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SENCILLA", "DOBLE", "TRIPLE", "SUITE", "SUITE PRESIDENCIAL"}, "SELECCIONE OPCIÓN");

                                if (tipoHabitacion.equalsIgnoreCase(habitacionBaja)) {

                                    fi = new FileInputStream(bajasArchivo);
                                    di = new DataInputStream(fi);

                                    while (di.available() != 0) {

                                        seguir = false;

                                        a = di.readUTF();
                                        b = di.readUTF();
                                        c = di.readUTF();

                                        if (a.equalsIgnoreCase(tipoHabitacion)) {
                                            if (b.equalsIgnoreCase(salida)) {
                                                if (c.equalsIgnoreCase(RFC1)) {
                                                    seguir = true;
                                                    break;
                                                }
                                            }
                                        }

                                        fi.close();
                                        di.close();
                                    }

                                    if (seguir) {
                                        if (tipoHabitacion.equalsIgnoreCase("SENCILLA")) {
                                            sencilla++;
                                            cont++;
                                            ds.writeUTF(tipoHabitacion);
                                            ds.writeUTF(salida);
                                            ds.writeUTF(RFC1);
                                            JOptionPane.showMessageDialog(null, salida + " debe pagar $ " + total + " pesos", "TOTAL A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                            JOptionPane.showMessageDialog(null, "Gracias por su visita regrese Pronto", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
                                        } else {

                                            if (tipoHabitacion.equals("DOBLE")) {

                                                if (doble < 10) {
                                                    doble++;
                                                    cont++;
                                                    ds.writeUTF(tipoHabitacion);
                                                    ds.writeUTF(salida);
                                                    ds.writeUTF(RFC1);
                                                    JOptionPane.showMessageDialog(null, salida + " debe pagar $ " + total + " pesos", "TOTAL A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                                    JOptionPane.showMessageDialog(null, "Gracias por su visita regrese Pronto", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No existen habitaciones de éstas en uso", "EROOR", JOptionPane.ERROR_MESSAGE);
                                                }

                                            } else {

                                                if (tipoHabitacion.equals("TRIPLE")) {

                                                    if (triple < 10) {
                                                        triple++;
                                                        cont++;
                                                        ds.writeUTF(tipoHabitacion);
                                                        ds.writeUTF(salida);
                                                        ds.writeUTF(RFC1);
                                                        JOptionPane.showMessageDialog(null, salida + " debe pagar $ " + total + " pesos", "TOTAL A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                                        JOptionPane.showMessageDialog(null, "Gracias por su visita regrese Pronto", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "No existen habitaciones de éstas en uso", "EROOR", JOptionPane.ERROR_MESSAGE);
                                                    }

                                                } else {

                                                    if (tipoHabitacion.equals("SUITE")) {

                                                        if (suite < 5) {
                                                            suite++;
                                                            cont++;
                                                            ds.writeUTF(tipoHabitacion);
                                                            ds.writeUTF(salida);
                                                            ds.writeUTF(RFC1);
                                                            JOptionPane.showMessageDialog(null, salida + " debe pagar $ " + total + " pesos", "TOTAL A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                                            JOptionPane.showMessageDialog(null, "Gracias por su visita regrese Pronto", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "No existen habitaciones de éstas en uso", "EROOR", JOptionPane.ERROR_MESSAGE);
                                                        }

                                                    } else {

                                                        if (suitePresidencial < 2) {
                                                            suitePresidencial++;
                                                            cont++;
                                                            ds.writeUTF(tipoHabitacion);
                                                            ds.writeUTF(salida);
                                                            ds.writeUTF(RFC1);
                                                            JOptionPane.showMessageDialog(null, salida + " debe pagar $ " + total + " pesos", "TOTAL A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                                            JOptionPane.showMessageDialog(null, "Gracias por su visita regrese Pronto", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "No existen habitaciones de éstas en uso", "EROOR", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La persona con esos datos ya se dio de baja\n Lamentamos las molestias\n HOTEL MARAVILLAS LE DA LOS MÁS COORDIALES AGRADECIMIENTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "El tipo de habitación, no coincide con la persona que la pidio\n Lamentamos las molestias", "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        */
                    }                       
                    break;

                case 2:
                    fosi = new FileOutputStream(precios, true);

                    int opcion2 = JOptionPane.showOptionDialog(null, "MODIFICAR PRECIOS", "Menú Principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sencilla", "Doble", "Triple", "Suite", "Suite Presidencial", "SALIR"}, null);

                    switch (opcion2) {

                        case 0:
                            do {
                                bandera = false;
                                seguir = false;

                                try {
                                    do {
                                        pago1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese nuevo Costo de la Habitacion Sencilla", "MODIFICACI{ON", JOptionPane.INFORMATION_MESSAGE));
                                        seguir = true;
                                        if (pago1 == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un valor IGUAL a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            if (pago1 < 0) {
                                                JOptionPane.showMessageDialog(null, "Ingreso un valor MENOR a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } while (pago1 <= 0);

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                    bandera = true;
                                }

                            } while (bandera);
                            break;

                        case 1:
                            do {
                                bandera = false;
                                seguir = false;

                                try {
                                    do {
                                        pago2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese nuevo Costo de la Habitacion Doble", "MODIFICACI{ON", JOptionPane.INFORMATION_MESSAGE));
                                        seguir = true;
                                        if (pago2 == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un valor IGUAL a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            if (pago2 < 0) {
                                                JOptionPane.showMessageDialog(null, "Ingreso un valor MENOR a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } while (pago2 <= 0);

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                    bandera = true;
                                }

                            } while (bandera);
                            break;

                        case 2:
                            do {
                                bandera = false;
                                seguir = false;

                                try {
                                    do {
                                        pago3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese nuevo Costo de la Habitacion Triple", "MODIFICACI{ON", JOptionPane.INFORMATION_MESSAGE));
                                        seguir = true;
                                        if (pago3 == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un valor IGUAL a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            if (pago3 < 0) {
                                                JOptionPane.showMessageDialog(null, "Ingreso un valor MENOR a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } while (pago3 <= 0);

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                    bandera = true;
                                }

                            } while (bandera);
                            break;

                        case 3:
                            do {
                                bandera = false;
                                seguir = false;

                                try {
                                    do {
                                        pago4 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese nuevo Costo de la habitacion suite", "MODIFICACI{ON", JOptionPane.INFORMATION_MESSAGE));
                                        seguir = true;
                                        if (pago4 == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un valor IGUAL a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            if (pago4 < 0) {
                                                JOptionPane.showMessageDialog(null, "Ingreso un valor MENOR a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } while (pago4 <= 0);

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                    bandera = true;
                                }

                            } while (bandera);
                            break;

                        case 4:
                            do {
                                bandera = false;
                                seguir = false;

                                try {
                                    do {
                                        pago5 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese nuevo Costo de la habitacion suitePresidencial", "MODIFICACI{ON", JOptionPane.INFORMATION_MESSAGE));
                                        seguir = true;
                                        if (pago5 == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un valor IGUAL a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            if (pago5 < 0) {
                                                JOptionPane.showMessageDialog(null, "Ingreso un valor MENOR a cero\n Le pedimos de favor, vuelva a ingresar los datos,\n ¡¡ Lamentamos las molestias !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } while (pago5 <= 0);

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                                    bandera = true;
                                }

                            } while (bandera);
                            break;

                        case 5:
                            JOptionPane.showMessageDialog(null, "GRACIAS POR USAR ÉSTE APARTADO", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }

                    if (seguir) {
                        dosi = new DataOutputStream(fosi);
                        dosi.writeDouble(pago1);
                        dosi.writeDouble(pago2);
                        dosi.writeDouble(pago3);
                        dosi.writeDouble(pago4);
                        dosi.writeDouble(pago5);

                        fosi.close();
                        dosi.close();

                        fisi = new FileInputStream(precios);
                        disi = new DataInputStream(fisi);

                        while (disi.available() != 0) {
                            q = disi.readDouble();
                            p = disi.readDouble();
                            o = disi.readDouble();
                            u = disi.readDouble();
                            y = disi.readDouble();
                            pago1 = q;
                            pago2 = p;
                            pago3 = o;
                            pago4 = u;
                            pago5 = y;

                        }

                        disi.close();
                        fisi.close();
                    }
                    break;

                case 3:

                    fis = new FileInputStream(nomArchivo);
                    dis = new DataInputStream(fis);

                    if (dis.available() == 0) {
                        JOptionPane.showMessageDialog(null, "No se han registrado datos en el archivo\n Lamentamos las molestias", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {

                        if (dis.available() != 0) {
                            System.out.println("\n Registros guardados en el archivo...");
                            System.out.println("\n\n------------------------------------------------------------ALTAS-----------------------------------------------------------------");
                            System.out.println("Nombre\t\t\tRFC\t\t\t\tCorreo\t\t\t\t\tTeléfono\t\tHabitación\t\t\tNúmero Cuarto\t\t\tFecha y Hora de Entrada\t\t\tEstancia\t\tFecha y Hora de Salida\t\t\tTotal");
                        }

                        while (dis.available() != 0) {
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(dis.readUTF() + "\t\t\t" + dis.readUTF() + "\t\t\t" + dis.readUTF() + "\t\t\t" + dis.readUTF() + "\t\t\t" + dis.readUTF() + "\t\t\t" + dis.readInt() + "\t\t\t" + dis.readUTF() + "\t\t\t" + dis.readInt() + "\t\t\t" + dis.readUTF() + "\t\t\t" + dis.readFloat());
                        }

                        fis.close();
                        dis.close();
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "   GRACIAS POR USAR ESTE SOFTWARE\n LO ESPERAMOS DE VUELTA MUY PRONTO\n                        CREADO POR:\n          Mario Josué del Toro Morales\n               Alejandro García Álvarez", "AGRADECIMIENTO", 3);
                    break;
            }

        } while (opcion != 4);
    }
}
/*
while (dis.available() != 0) {
a = dis.readUTF();
b = dis.readUTF();
c = dis.readUTF();
d = dis.readUTF();
z = dis.readUTF();
f = dis.readInt();
g = dis.readUTF();
h = dis.readInt();
x = dis.readUTF();
j = dis.readFloat();
 if (a.equalsIgnoreCase(salida)) {
 dos.write.UTF("");                                     
                                        break;
                                    }
                                }

                                fis.close();
                                dis.close();
     
*/
