PGDMP          9    	            {            postgres    15.1    15.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            	           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            
           1262    5    postgres    DATABASE     {   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE postgres;
                postgres    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3338                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false                       0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            ?            1259    16551    detalle    TABLE     ?   CREATE TABLE public.detalle (
    id_detalle integer NOT NULL,
    articulo character(80) NOT NULL,
    cantidad integer NOT NULL,
    valor integer NOT NULL,
    id_factura integer NOT NULL
);
    DROP TABLE public.detalle;
       public         heap    postgres    false            ?            1259    16550    detalle_id_detalle_seq    SEQUENCE     ?   CREATE SEQUENCE public.detalle_id_detalle_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.detalle_id_detalle_seq;
       public          postgres    false    218                       0    0    detalle_id_detalle_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.detalle_id_detalle_seq OWNED BY public.detalle.id_detalle;
          public          postgres    false    217            ?            1259    16498    factura    TABLE     ?   CREATE TABLE public.factura (
    id_factura integer NOT NULL,
    nombre text NOT NULL,
    cliente text NOT NULL,
    fecha date NOT NULL,
    subtotal integer NOT NULL,
    iva integer NOT NULL,
    total integer NOT NULL
);
    DROP TABLE public.factura;
       public         heap    postgres    false            ?            1259    16497    factura_id_factura_seq    SEQUENCE     ?   CREATE SEQUENCE public.factura_id_factura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.factura_id_factura_seq;
       public          postgres    false    216                       0    0    factura_id_factura_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.factura_id_factura_seq OWNED BY public.factura.id_factura;
          public          postgres    false    215            l           2604    16554    detalle id_detalle    DEFAULT     x   ALTER TABLE ONLY public.detalle ALTER COLUMN id_detalle SET DEFAULT nextval('public.detalle_id_detalle_seq'::regclass);
 A   ALTER TABLE public.detalle ALTER COLUMN id_detalle DROP DEFAULT;
       public          postgres    false    218    217    218            k           2604    16501    factura id_factura    DEFAULT     x   ALTER TABLE ONLY public.factura ALTER COLUMN id_factura SET DEFAULT nextval('public.factura_id_factura_seq'::regclass);
 A   ALTER TABLE public.factura ALTER COLUMN id_factura DROP DEFAULT;
       public          postgres    false    216    215    216                      0    16551    detalle 
   TABLE DATA           T   COPY public.detalle (id_detalle, articulo, cantidad, valor, id_factura) FROM stdin;
    public          postgres    false    218   )                 0    16498    factura 
   TABLE DATA           [   COPY public.factura (id_factura, nombre, cliente, fecha, subtotal, iva, total) FROM stdin;
    public          postgres    false    216   ?                  0    0    detalle_id_detalle_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.detalle_id_detalle_seq', 15, true);
          public          postgres    false    217                       0    0    factura_id_factura_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.factura_id_factura_seq', 15, true);
          public          postgres    false    215            p           2606    16556    detalle detalle_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.detalle
    ADD CONSTRAINT detalle_pkey PRIMARY KEY (id_detalle);
 >   ALTER TABLE ONLY public.detalle DROP CONSTRAINT detalle_pkey;
       public            postgres    false    218            n           2606    16503    factura factura_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id_factura);
 >   ALTER TABLE ONLY public.factura DROP CONSTRAINT factura_pkey;
       public            postgres    false    216            q           1259    16562    fki_fkfactura    INDEX     G   CREATE INDEX fki_fkfactura ON public.detalle USING btree (id_factura);
 !   DROP INDEX public.fki_fkfactura;
       public            postgres    false    218            r           2606    16557    detalle fkfactura    FK CONSTRAINT     ?   ALTER TABLE ONLY public.detalle
    ADD CONSTRAINT fkfactura FOREIGN KEY (id_factura) REFERENCES public.factura(id_factura) NOT VALID;
 ;   ALTER TABLE ONLY public.detalle DROP CONSTRAINT fkfactura;
       public          postgres    false    218    216    3182               ?   x?3?I,?J-IT?p?W?(J??,??T prqr?Í.?/?L???x?Ѧ ?P??txaqfr>%?n?ih?eh??nJ?9? l?gpiqrQfAr???y
???%?I????I?S /x??7?24???M?b???? ??kz         b   x?Eʽ
? ???;?bx<B6??A??d??u??????0???7`?w:???(??0?E?#?9?7?????Ɓ?b?&???i?????VC`????~?$?     