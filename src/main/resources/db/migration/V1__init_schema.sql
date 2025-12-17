
CREATE SCHEMA IF NOT EXISTS emp_mgmt;

--
-- Name: employees; Type: TABLE; Schema: emp_mgmt; Owner: postgres
--

CREATE TABLE emp_mgmt.employees (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255),
    department character varying(100),
    salary double precision
);


ALTER TABLE emp_mgmt.employees OWNER TO postgres;

--
-- Name: employees_id_seq; Type: SEQUENCE; Schema: emp_mgmt; Owner: postgres
--

ALTER TABLE emp_mgmt.employees ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME emp_mgmt.employees_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: users; Type: TABLE; Schema: emp_mgmt; Owner: postgres
--

CREATE TABLE emp_mgmt.users (
    id bigint NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255) NOT NULL
);


ALTER TABLE emp_mgmt.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: emp_mgmt; Owner: postgres
--

CREATE SEQUENCE emp_mgmt.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE emp_mgmt.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: emp_mgmt; Owner: postgres
--

ALTER SEQUENCE emp_mgmt.users_id_seq OWNED BY emp_mgmt.users.id;


--
-- Name: users id; Type: DEFAULT; Schema: emp_mgmt; Owner: postgres
--

ALTER TABLE ONLY emp_mgmt.users ALTER COLUMN id SET DEFAULT nextval('emp_mgmt.users_id_seq'::regclass);


--
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: emp_mgmt; Owner: postgres
--

ALTER TABLE ONLY emp_mgmt.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: emp_mgmt; Owner: postgres
--

ALTER TABLE ONLY emp_mgmt.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: emp_mgmt; Owner: postgres
--

ALTER TABLE ONLY emp_mgmt.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- PostgreSQL database dump complete
--