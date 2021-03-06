package CyelPostLicence;

/** 
 * Helper class for : Universite
 *  
 * @author OpenORB Compiler
 */ 
public class UniversiteHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert Universite into an any
     * @param a an any
     * @param t Universite value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Universite t)
    {
        a.insert_Streamable(new CyelPostLicence.UniversiteHolder(t));
    }

    /**
     * Extract Universite from an any
     * @param a an any
     * @return the extracted Universite value
     */
    public static CyelPostLicence.Universite extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.UniversiteHolder)
                    return ((CyelPostLicence.UniversiteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.UniversiteHolder h = new CyelPostLicence.UniversiteHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the Universite TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "numUniv";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomUniv";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "academie";
                _members[2].type = CyelPostLicence.AcademieHelper.type();
                _tc = orb.create_struct_tc(id(),"Universite",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Universite IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Universite:1.0";

    /**
     * Read Universite from a marshalled stream
     * @param istream the input stream
     * @return the readed Universite value
     */
    public static CyelPostLicence.Universite read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Universite new_one = new CyelPostLicence.Universite();

        new_one.numUniv = istream.read_long();
        new_one.nomUniv = istream.read_string();
        new_one.academie = CyelPostLicence.AcademieHelper.read(istream);

        return new_one;
    }

    /**
     * Write Universite into a marshalled stream
     * @param ostream the output stream
     * @param value Universite value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Universite value)
    {
        ostream.write_long(value.numUniv);
        ostream.write_string(value.nomUniv);
        CyelPostLicence.AcademieHelper.write(ostream,value.academie);
    }

}
