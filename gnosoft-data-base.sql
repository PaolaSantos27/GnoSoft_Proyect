PGDMP     7                    z            postgres    15.1    15.1     
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    5    postgres    DATABASE     {   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE postgres;
                postgres    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3341                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false                       0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16406    factura_datos    TABLE     �   CREATE TABLE public.factura_datos (
    id_dato bigint NOT NULL,
    id_factura bigint,
    nombre character(100),
    cliente character(100),
    fecha date,
    subtotal bigint NOT NULL,
    iva bigint NOT NULL,
    total bigint NOT NULL
);
 !   DROP TABLE public.factura_datos;
       public         heap    postgres    false            �            1259    16404    factura_datos_iva_seq    SEQUENCE     ~   CREATE SEQUENCE public.factura_datos_iva_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.factura_datos_iva_seq;
       public          postgres    false    219                       0    0    factura_datos_iva_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.factura_datos_iva_seq OWNED BY public.factura_datos.iva;
          public          postgres    false    217            �            1259    16403    factura_datos_subtotal_seq    SEQUENCE     �   CREATE SEQUENCE public.factura_datos_subtotal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.factura_datos_subtotal_seq;
       public          postgres    false    219                       0    0    factura_datos_subtotal_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.factura_datos_subtotal_seq OWNED BY public.factura_datos.subtotal;
          public          postgres    false    216            �            1259    16405    factura_datos_total_seq    SEQUENCE     �   CREATE SEQUENCE public.factura_datos_total_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.factura_datos_total_seq;
       public          postgres    false    219                       0    0    factura_datos_total_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.factura_datos_total_seq OWNED BY public.factura_datos.total;
          public          postgres    false    218            �            1259    16398    facturacion    TABLE     �   CREATE TABLE public.facturacion (
    id_factura bigint NOT NULL,
    articulo character(100),
    cantidad bigint,
    valor bigint
);
    DROP TABLE public.facturacion;
       public         heap    postgres    false            l           2604    16409    factura_datos subtotal    DEFAULT     �   ALTER TABLE ONLY public.factura_datos ALTER COLUMN subtotal SET DEFAULT nextval('public.factura_datos_subtotal_seq'::regclass);
 E   ALTER TABLE public.factura_datos ALTER COLUMN subtotal DROP DEFAULT;
       public          postgres    false    219    216    219            m           2604    16410    factura_datos iva    DEFAULT     v   ALTER TABLE ONLY public.factura_datos ALTER COLUMN iva SET DEFAULT nextval('public.factura_datos_iva_seq'::regclass);
 @   ALTER TABLE public.factura_datos ALTER COLUMN iva DROP DEFAULT;
       public          postgres    false    219    217    219            n           2604    16411    factura_datos total    DEFAULT     z   ALTER TABLE ONLY public.factura_datos ALTER COLUMN total SET DEFAULT nextval('public.factura_datos_total_seq'::regclass);
 B   ALTER TABLE public.factura_datos ALTER COLUMN total DROP DEFAULT;
       public          postgres    false    218    219    219                      0    16406    factura_datos 
   TABLE DATA           j   COPY public.factura_datos (id_dato, id_factura, nombre, cliente, fecha, subtotal, iva, total) FROM stdin;
    public          postgres    false    219   �                 0    16398    facturacion 
   TABLE DATA           L   COPY public.facturacion (id_factura, articulo, cantidad, valor) FROM stdin;
    public          postgres    false    215   �                  0    0    factura_datos_iva_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.factura_datos_iva_seq', 1, false);
          public          postgres    false    217                       0    0    factura_datos_subtotal_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.factura_datos_subtotal_seq', 1, false);
          public          postgres    false    216                       0    0    factura_datos_total_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.factura_datos_total_seq', 1, false);
          public          postgres    false    218            r           2606    16413     factura_datos factura_datos_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.factura_datos
    ADD CONSTRAINT factura_datos_pkey PRIMARY KEY (id_dato);
 J   ALTER TABLE ONLY public.factura_datos DROP CONSTRAINT factura_datos_pkey;
       public            postgres    false    219            p           2606    16402    facturacion facturacion_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.facturacion
    ADD CONSTRAINT facturacion_pkey PRIMARY KEY (id_factura);
 F   ALTER TABLE ONLY public.facturacion DROP CONSTRAINT facturacion_pkey;
       public            postgres    false    215            s           1259    16419    fki_fkfactura    INDEX     M   CREATE INDEX fki_fkfactura ON public.factura_datos USING btree (id_factura);
 !   DROP INDEX public.fki_fkfactura;
       public            postgres    false    219            t           2606    16414    factura_datos fkfactura    FK CONSTRAINT     �   ALTER TABLE ONLY public.factura_datos
    ADD CONSTRAINT fkfactura FOREIGN KEY (id_factura) REFERENCES public.facturacion(id_factura) NOT VALID;
 A   ALTER TABLE ONLY public.factura_datos DROP CONSTRAINT fkfactura;
       public          postgres    false    3184    215    219               �   x��ұ1��{
�}�S�@�DGC��r�!�؉)X���a �����}����l�t��a���DH���qȥ�4�foӔ���6#�P�G�]���y�q����PyyNU��-׭��m@��������#b�i>��2;������x�o@�t\�㟃         �   x�3�I,�J-IT�K-I�ɬP��I�Sp:��839_S�:�ӈ�Ā�nYpA~IfZ%в�����\j��ː�Д�n������c�cԵ�/.�����̂��Û�"�KKJ�R��9���L���R!�$�h���
5��1#�=... )�dk     