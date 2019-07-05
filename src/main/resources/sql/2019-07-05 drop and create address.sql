DROP TABLE IF EXISTS public.address;

CREATE TABLE public.address
(
  id serial,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  address character varying(255) NOT NULL,
  mainaddress boolean,
  person_id bigint,
  CONSTRAINT address_pkey PRIMARY KEY (id),
  CONSTRAINT address_person_fkey FOREIGN KEY (person_id)
      REFERENCES public.person (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
