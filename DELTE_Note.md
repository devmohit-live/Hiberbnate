When Only Deleting 1 type in a pair which are bound (mapped) to each other
either uni or bi
we have to change cascade property from that type (which we want to be deleted)

//ex: if you want to delete instructor details type but want instructor to be there then

//1 instructor type must not have delete cacade =>(provide all other individual cascade type except remove)
//2 before delteing that instructor of that associated detaisl must set it's details property to null
// ex: InstrDetail det = session.get(InsDe.class,2);
det.getInstrucor().setInstructorDetails(null); // this should be done

//3 now delte it


//Similary 
For vice versa

However the current db doen't allows that, we can delete the details but not the instructor(ex take a fb profile, it is wise to delte dp but not to keep dp and delete the profile)
bi-directional here means read and access data from anyone of them as access/entry point
